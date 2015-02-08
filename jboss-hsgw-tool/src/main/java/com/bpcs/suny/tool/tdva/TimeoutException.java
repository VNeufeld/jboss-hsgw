package com.bpcs.suny.tool.tdva;


public class TimeoutException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TimeoutException(String message) {
		super (message);
	}

	public TimeoutException(String message, Exception e) {
		super (message, e);
	}
}
