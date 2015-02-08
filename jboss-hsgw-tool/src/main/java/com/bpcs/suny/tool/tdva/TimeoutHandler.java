package com.bpcs.suny.tool.tdva;

import org.apache.log4j.Logger;

/**
 * This runnable will be started before blocking IO-operations. If the operation returns 
 * before the TimeoutHandler is done, the handler can be stopped. (normal operation).
 * If the handler reaches timeout, it will close the socket. This causes the blocking 
 * operation to return. (failing operation). 
 * 
 * @author Matthias Brenner
 *
 */
class TimeoutHandler implements Runnable {
	Logger LOG = Logger.getLogger(TimeoutHandler.class);
	
	private long 				timeout;
	private final ControlledTask 	task;
	private final long				id;
	
	public TimeoutHandler(ControlledTask task) {
		this.timeout = task.getTimeout();
		this.task = task;
		this.id = task.getId();
	}

	@Override
	public void run() {
		try{
			if (LOG.isDebugEnabled())
				LOG.debug("start timeout counter on TDVA " + id);
			
			Thread.sleep(timeout);
		}
		catch(InterruptedException e){
			if (LOG.isDebugEnabled())
				LOG.debug("stop timeout counter on TDVA " + id);
			
			// ignore, this is the normal case, the timeout does not terminate the connection
			return;
		}
		
		// timeout occured, terminate the connection, this leads to an IOException at the proxy. 
		LOG.info("timeout on TDVA " + id);
		task.terminateTask();
	}

	void setTimeout(long timeout) {
		this.timeout = timeout;
	}
 }