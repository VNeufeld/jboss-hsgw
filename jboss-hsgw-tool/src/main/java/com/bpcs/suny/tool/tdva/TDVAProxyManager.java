package com.bpcs.suny.tool.tdva;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;


/**
 * The class maintains all active TDVA proxies.
 * 
 * @author Matthias Brenner
 *
 */
public class TDVAProxyManager {
    private static final Logger LOG = Logger.getLogger(TDVAProxyManager.class);

    
    
    public static final String timeoutResponse = "<START><Administration><Error><ID>1</ID><Text>BackendError</Text></Error></Administration></START";
   
    
    
    private static final int MAX_NUMBER_TDVA = 100;



	private char tdvaPackageDelimiter = (char) 0xa4;;
	
	private static TDVAProxyManager singleton;

	private static List<String> tagsToBeAnonymized = null;
	
	private final AtomicInteger proxyInstanciationCounter;
	private long tdvaTimeout;
	private final AtomicInteger tdvaCount;
	
	private final BlockingQueue<ProxyAdministrationStructure> tdvaPool;

	
	
	
	private class ProxyAdministrationStructure {

		TDVAProxy proxy;
		Thread timeoutThread = null;
		TimeoutHandler timeoutHandler;
		
		public ProxyAdministrationStructure(TDVAProxy proxy) {
			
			this.proxy = proxy;
			
			// prepare timeout handling, used during each blocking operation
			timeoutHandler = new TimeoutHandler(proxy);
		}
		
		void startTimeout(long timeout) {
			// start watchdog timer for individual calls
			try{
				timeoutHandler.setTimeout(timeout);
				timeoutThread = new Thread (timeoutHandler, "timeout_tdvaProxy_" + proxy.getId());

				timeoutThread.start();
			}
			catch(Exception e){
				LOG.debug("could not start timeout", e);
			}
		}
		
		void cancelTimeout () {
			// stop timer
			if(isTimerRunning()){
				timeoutThread.interrupt();
				timeoutThread = null;
			}
		}

		public boolean isTimerRunning() {
			return timeoutThread != null && timeoutThread.isAlive();
		}
	}
	
	
	
	//instantiation and singleton handling
	private TDVAProxyManager() {
		LOG.debug("instantiate proxy manager");
		
		tdvaPool = createTdvaPool();
		
		tdvaCount = new AtomicInteger();
		tdvaCount.set(0);
		
		proxyInstanciationCounter = new AtomicInteger();
		proxyInstanciationCounter.set(0);
	}

	private BlockingQueue<ProxyAdministrationStructure> createTdvaPool() {
		BlockingQueue<ProxyAdministrationStructure> tdvaPool = new LinkedBlockingQueue<ProxyAdministrationStructure>(MAX_NUMBER_TDVA);
		
		return tdvaPool;
	}

	private static TDVAProxyManager getInstance () {
		synchronized(TDVAProxyManager.class){
			if (singleton == null)
				singleton = new TDVAProxyManager();
		}
		
		return singleton;
	}
	
	
	
	/**
	 * add additonal proxy to the maintenance structures
	 * @param proxy
	 */
	static void addProxy (TDVAProxy proxy) {
		
		getInstance()._addProxy(proxy);
	}
	
	private void _addProxy (TDVAProxy proxy){
		
		ProxyAdministrationStructure admin = new ProxyAdministrationStructure(proxy);
		tdvaPool.add(admin);
		tdvaCount.incrementAndGet();

		LOG.debug("added TDVA: " + proxy.getId());
	}

	
	
	static long getNextId() {
		return getInstance()._getNextId();
	}
	
	private synchronized long _getNextId() {
		return proxyInstanciationCounter.incrementAndGet();
	}
	
	public static void init(long tdvaTimeout, char packageDelimiter) {
		getInstance()._init(tdvaTimeout, packageDelimiter);
	}

	private void _init(long tdvaTimeout, char packageDelimiter) {
		this.tdvaTimeout = tdvaTimeout;
		this.tdvaPackageDelimiter = packageDelimiter;
	}

	
	

	private ProxyAdministrationStructure _acquireProxy(long timeout) throws InterruptedException, TimeoutException {
		
		// will block till free TDVA becomes available or is interrupted by the timeout thread
		LOG.info("acquire a proxy");
		ProxyAdministrationStructure admin = tdvaPool.poll(tdvaTimeout, TimeUnit.MILLISECONDS);
		
		if (admin == null) 
			throw new TimeoutException("could not acquire proxy");
		LOG.info("assigned TDVA " + admin.proxy.getId());
		
		return admin;
	}

	

	private void _releaseProxy (ProxyAdministrationStructure admin) {
		tdvaPool.add(admin);
	}

	
	
	static List<String> getTagsToBeAnonymized() {
		return TDVAProxyManager.tagsToBeAnonymized;
	}
	
	static void setTagsToBeAnonymized (List<String> tagsToBeAnonymized) {
		TDVAProxyManager.tagsToBeAnonymized = tagsToBeAnonymized;
	}

	static char getTdvaPackageDelimiter() {
		return getInstance().tdvaPackageDelimiter;
	}
	
	public static void setTdvaPackageDelimiter(char tdvaPackageDelimiter) {
		getInstance().tdvaPackageDelimiter = tdvaPackageDelimiter;  
	}
	
	
	
	public static String tdvaRequest(String request) throws NoContentException, TimeoutException {
			TDVAProxyManager manager = getInstance();
			return manager._tdvaRequest(request);
	}
	
	private String _tdvaRequest(String request) throws TimeoutException, NoContentException {
		String result = null;
		long timeout = tdvaTimeout;
		
		LOG.info("request to TDVA");
		
		// try to apply to a TDVA, if the TDVA fails try the next
		boolean done = false;
		long startTime = System.currentTimeMillis();
		do {
			ProxyAdministrationStructure admin = null;
			
			if (startTime + tdvaTimeout < System.currentTimeMillis()) {
				LOG.error("could not get TDVA within timeout");
				break;
			}
			
			if (tdvaCount.get() == 0) {
				// no TDVA available
				LOG.info("no TDVA available, cannot serve request"); 
				break;
			}
			
			// find a TDVA to serve the request. 
			try{
				// get free proxy, may block. Will be interrupted on timeout
				admin = _acquireProxy(timeout);
				final long endTime = System.currentTimeMillis();
				timeout = timeout - (endTime - startTime);
	
				// start monitoring the TDVA request
				admin.startTimeout(timeout);
				
				// execute request
				result = admin.proxy.tdvaRequest(request, true);
				
				LOG.info("done with request on TDVA " + admin.proxy.getId());
			}
			catch (Throwable th) {
				LOG.error("communiation with TDVA " + admin.proxy.getId() + ": received unexpected exception", th);
				
				if (admin != null && admin.proxy != null) {
					try {
						admin.proxy.disconnect();
					}
					finally {
						admin.proxy = null; // just forget about it.
					}
					
				}
			}
			finally{
				// stop running timeout (if we could acquire a proxy)
				if (admin != null) {
					admin.cancelTimeout();
				
					// dispose proxy
					if (admin.proxy != null)
						_releaseProxy(admin);
				}
				
				done = result != null;
			}
		} while (! done);

		if(result == null)
			throw new NoContentException("did not receive any result");

		return result;
	}
}