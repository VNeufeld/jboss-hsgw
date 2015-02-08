package com.bpcs.suny.tool.tdva;

public class TdvaSettings {

	private int connectPort;

	private String provider;

	private char packageDelimiter;

	private long timeout;

	
	
	public int getConnectPort() {
		return connectPort;
	}

	public void setConnectPort(int connectPort) {
		this.connectPort = connectPort;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public char getPackageDelimiter() {
		return packageDelimiter;
	}

	public void setPackageDelimiter(char packageDelimiter) {
		this.packageDelimiter = packageDelimiter;
	}

	public long getTimeout() {
		return timeout;
	}

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}
}
