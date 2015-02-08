package com.bpcs.suny.tool.tdva;

/**
 * The interface denominates a task which needs to be controlled by a timeout handler. 
 * 
 * @author Matthias Brenner
 *
 */
public interface ControlledTask {

	/**
	 * Id of the task.
	 * 
	 * @return the id
	 */
	long getId ();
	
	/**
	 * stop task
	 */
	void terminateTask ();
	
	/**
	 * timeout till the task should be stopped
	 * 
	 * @return the timeout
	 */
	long getTimeout();
}