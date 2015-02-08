package com.bpcs.suny.tool.tdva;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;


/**
 * @author Markus Siegel, rewritten by Matthias Brenner
 */
public class TDVAListener implements Runnable
{
    private static final Logger LOG = Logger.getLogger(TDVAListener.class);


    private int tdvaConnectPort = 1992;
    private long tdvaTimeout = 15000;
    private final int tdvaKeepAlive = -1;
    
    
    
    public TDVAListener(TdvaSettings settings) {
    	
//    	if (tdvaKeepAlive > 0)
//    		this.tdvaKeepAlive = tdvaKeepAlive;
    	
		if (settings.getConnectPort() > 0)
			this.tdvaConnectPort = settings.getConnectPort();
		
		if (settings.getTimeout() > 0)
			this.tdvaTimeout = settings.getTimeout();
		
		TDVAProxyManager.init(tdvaTimeout, settings.getPackageDelimiter());
	}

    
    
    /**
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		ServerSocket listener = setupListenerOrTerminate();

		while(true){
			Socket tdvaSocket = null;
			try{
				// blocking call, till TDVA connects
				tdvaSocket = listener.accept();
			}
			catch(IOException e){
				LOG.error("giving up listening for TDVA", e);
				break;
			}

			// setup management objects for TDVA
			TDVAProxy proxy = null;
			try{
				proxy = new TDVAProxy(tdvaSocket, tdvaTimeout, tdvaKeepAlive);
			}
			catch(IOException e){
				LOG.error("could not initialize incomming connection request from TDVA", e);
				
				continue;
			}
			catch(NoContentException e){
				LOG.error("could not initialize incomming connection request from TDVA", e);
				
				continue;
			}
			TDVAProxyManager.addProxy(proxy);
		}

		try{
			if (!listener.isClosed())
				listener.close();
		}
		catch(Exception e){
			LOG.error("could not close listener, giving up", e);
		}
	}

	private ServerSocket setupListenerOrTerminate() {
		ServerSocket listener = null;
	
		try
		{
		    listener = new ServerSocket();
		    listener.bind(new InetSocketAddress(tdvaConnectPort), 50);
		}
		catch (IOException e)
		{
		    LOG.error("Requestor stop. Could not listen on TDVA port " + tdvaConnectPort + "\n" + e.getMessage());
		    LOG.error(e);
		    System.exit(0);
		}

		return listener;
	}
}