package com.bpcs.suny.tool.xml;



public class MarshallingException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MarshallingException(String message, Exception e) {
		super (message, e);
	}
}