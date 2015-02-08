package com.bpcs.suny.tool.tdva;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

import org.apache.log4j.Logger;



class TDVAProxy implements ControlledTask {
    private static final Logger LOG = Logger.getLogger(TDVAProxy.class);
    
    // TDVA RESPONSE
    private static final int 	RESPONSE_HEADER_LENGTH = 6;
	private static final String START_TAG_PREFIX = "<start>";
	private static final String DEFAULT_CHARSET = "ISO-8859-1";

    // TDVA REQUESTS
	private static String 	COMMAND_INIT      = "01@@SET_VERARB_ID@@";
	private static String 	COMMAND_TERMINATE = "01@@NFY_TERMINATE@@";
	private static String 	COMMAND_APPROVE   = "@@APPROVEREQUEST@@";
	private static String 	COMMAND_OK		  = "@@OK@@";
	private static String 	COMMAND_READY     = "@@READY@@";
	private static String 	COMMAND_NOTIFIY   = "01@@NOTIFIED@@";
	private static String 	COMMAND_RESEND   = "01@@RESEND@@";
	public static String 	COMMAND_ALIVE     = "01@@ALIVE@@";

	// PROVDER
    private static final String WEB_PROVIDER = "WEB";
    private static final String APP_Provider = "APP";
    private static final String DEFAULT_PROVIDER = WEB_PROVIDER;

    // internal organization
	private long id;
	private Socket socket;
	
	// parameters
	private long tdvaTimeout;
	private long tdvaKeepAliveIntervall;
	
    
    
	TDVAProxy(Socket socket, long tdvaTimeout, long tdvaKeepAliveIntervall) throws IOException, NoContentException {
		
		// prepare the socket
		this.socket = socket;
		socket.setKeepAlive(true);
		this.tdvaKeepAliveIntervall = tdvaKeepAliveIntervall;
		this.tdvaTimeout = tdvaTimeout;
		
		this.id = TDVAProxyManager.getNextId();
		
		// send init command to tdva
		try{
			tdvaRequest(StringUtils.setToLength(COMMAND_INIT + this.getId(), " ", 52, true), false);
		}
		catch(IOException e){
			// cannot happen, because no time is present
			LOG.error("TDVA " + id + ": unexpected interrupt");
			throw e;
		}
		
		if (LOG.isInfoEnabled())
			LOG.info("TDVA connected from " + getHostAddress() + ", assigned " + id);
	}

	
	
	/**
	 * Performs a single request on the TDVA. This method may be called from the TdvaProxyManager or from the TdvaWatchDog. 
	 * Therefore it is required to be synchronized to leave only one of both in the call. 
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws NoContentException 
	 */
	synchronized String tdvaRequest(String request, boolean responseRequired) throws IOException, NoContentException {
		if (LOG.isDebugEnabled())
			LOG.debug("TDVA " + id + ": begin of call ");
		
		String response = null;

		byte[] ba = transformRequest(createRawRequest(request));
		response = _tdvaRequest(ba, responseRequired);

		if (LOG.isDebugEnabled())
			LOG.debug("TDVA " + id + ": end of call");
		return response;
	}

	void disconnect() {
		if (LOG.isDebugEnabled())
			LOG.debug("TDVA " + id + ": disconnect");

		if (socket != null && ! socket.isClosed()) {
			try{
				socket.close();
			}
			catch(IOException e){
				// just ignore this case
				LOG.error("TDVA " + id + ": could not close socket", e);
			}
		}
		socket = null; // force garbage collector to claim the socket
	}



	/**
	 * internal request handling method. May not be exposed public, because does
	 * not synchronize calls. Therefore this call has to happen inside the
	 * synchronizing tdvaRequest.
	 * 
	 * @param ba
	 *        encoded request
	 * @return result of request
	 * @throws NoContentException
	 * @throws IOException 
	 */
	private String _tdvaRequest(byte[] ba, boolean responseRequired) throws IOException, NoContentException {
		String response = null;
		
		flushInput();
		
		writeOutput(ba);

		if (responseRequired) {
			response = readInput();

			interpreteResponse(response);
		}
		
		return response;
	}



	private void flushInput() throws IOException, UnsupportedEncodingException {
		do {
			int remainingContent = socket.getInputStream().available();
			if (remainingContent == 0)
				break;
			
			final int DEFAUL_BUFFER_SIZE = 200;
			byte[] garbage = new byte[DEFAUL_BUFFER_SIZE];
			int offset = 0;
			do {
				if (remainingContent + offset > DEFAUL_BUFFER_SIZE)
					remainingContent = DEFAUL_BUFFER_SIZE - offset;
				
				socket.getInputStream().read(garbage, offset, remainingContent);
				offset += remainingContent;
				remainingContent = socket.getInputStream().available();
				
			} while (offset < DEFAUL_BUFFER_SIZE && remainingContent > 0);
			
			LOG.error("TDVA " + id + ": found remaining content in buffer: " + new String (garbage, DEFAULT_CHARSET));
			
		} while (true);
	}
	
	private void interpreteResponse(String response) throws IOException, NoContentException {
		
		boolean isSystemMessage = true;
		while(isSystemMessage){
			if(response.indexOf(COMMAND_APPROVE) != -1){
				byte[] ba = null;
				ba = transformRequest(createCommandRequest(COMMAND_OK));
				
				response = _tdvaRequest(ba, true);
				continue;
			}
			else if(response.indexOf(COMMAND_READY) > -1){
				response = readInput();
			}
			else if(response.indexOf(COMMAND_NOTIFIY) > -1){
				break;
			}
			else{
				isSystemMessage = false;
			}

		}
	}

	private String createRawRequest(String request) {
		
		String rawRequest;

		if(request.toLowerCase().endsWith("</start>")){
			rawRequest = this.createDataRequest(request);
		}
		else{
			rawRequest = this.createCommandRequest(request);
		}
		
		return rawRequest;
	}
	
	private String createCommandRequest(String request) {
		
		// commands only require a simple header
		request = getHeader() + request;
		LOG.info("TDVA " + id + ": build command request: " + request);

		return request;
	}

	private String createDataRequest(String request) {
		String lowerRequest = request.toLowerCase();

		int beginIndex = 0;

		// cut off the XML intro
		if (request.startsWith("<?xml version"))
		{
			beginIndex = lowerRequest.indexOf(START_TAG_PREFIX);
			if(beginIndex == -1){
				// data request has to have the start-tag
				throw new ProtocolException("could not identify begin of message");
			}
		}

		String prefix = StringUtils.setToLength("00" + DEFAULT_PROVIDER, " ", 52, true);

		String preparedRequest = 
			  getHeader()
			+ prefix
			+ StringUtils.setToLength("<XML!>", " ", 14, true) 
			+ request.substring(beginIndex);

		return preparedRequest;
	}

	private void setLength(byte[] ba, int length) {
		int lowByte = length / 256;
		int highByte = length % 256;
		ba[4] = (byte) lowByte;
		ba[5] = (byte) highByte;
	}
	
	private String getHeader() {
		return TDVAProxyManager.getTdvaPackageDelimiter() + "00000";
	}
	
	private String readInput() throws IOException, NoContentException {
		String response = null;

		InputStream in = socket.getInputStream();

		int length = readHeader(in);

		// read response
		byte[] inBuffer = new byte[length - RESPONSE_HEADER_LENGTH];
		int offset = 0;
		int count;
		do{
			count = fillBuffer(inBuffer, offset);
			
			offset += count;
			LOG.info("TDVA " + id + ": Received: " + StringUtils.logAnonymXML(new String(inBuffer), TDVAProxyManager.getTagsToBeAnonymized()));
		}
		while(offset < inBuffer.length && count > 0);
		if (LOG.isDebugEnabled()) 
			LOG.debug("TDVA " + id + ": got: " + new String (inBuffer));

		response = transformResponse(inBuffer);
		
		checkSuperfluousBytes(in);

		return response;
	}
	
	private int readHeader(InputStream in) throws IOException, NoContentException {
		
		int length = readLengthFromHeader(in);
		
		if (length <= RESPONSE_HEADER_LENGTH) {
			// no content in message, issue resend command to TDVA and read header again.
			
			checkSuperfluousBytes(in);
			resend();
			
			length = readLengthFromHeader(in);
			if (length <= RESPONSE_HEADER_LENGTH) {
				// TDVA still corrupt, hang in
				disconnect();
				throw new IOException("TDVA " + id + "corrupt, force reinitialization, close socket");
			}
		}
		return length;
	}



	private void checkSuperfluousBytes(InputStream in) throws IOException {
		int available = in.available();
		if (available >= RESPONSE_HEADER_LENGTH) {
			disconnect();
			throw new IOException("TDVA sends bytes after EOF");
		}
	}

	private void resend() throws IOException {
		byte[] ba = transformRequest(createCommandRequest(COMMAND_RESEND));
		writeOutput(ba);
	}

	private int fillBuffer(byte[] inBuffer, int offset) throws IOException {
		int count;
		count = socket.getInputStream().read(inBuffer, offset, inBuffer.length - offset);
		if (count < 0) {
			// EOF
			throw new IOException("could not read beyond EOF");
		}
		return count;
	}

	private int readLengthFromHeader(InputStream in) throws IOException {
		// read length of response
		if (LOG.isDebugEnabled())
			LOG.debug("TDVA " + id + ": reading header:");
		byte[] headerBuffer = new byte[RESPONSE_HEADER_LENGTH];
		int bytesRead = in.read(headerBuffer);
		if (bytesRead < 0) {
			// EOF
			throw new IOException("could not read beyond EOF");
		}
		if(bytesRead != RESPONSE_HEADER_LENGTH){
			LOG.error("TDVA " + id + ": encountered EOF during reading header");
			throw new IOException("could not read header");
		}
		
		// determine length of data packet
		int length = computeLength(headerBuffer);
		if (LOG.isDebugEnabled())
			LOG.debug("TDVA " + id + ": got header: " + new String (headerBuffer) + "(" + ByteUtils.bytesToHex(headerBuffer) + "); length = "  + length);
		return length;
	}

	private void writeOutput(byte[] ba) throws IOException {
		OutputStream out = null;
		try{
			if (socket == null) {
				// may be closed by the parallel running watch dog.
				throw new IOException("TDVA " + id + ": socket is already closed, cannot write");
			}
			out = socket.getOutputStream();
			System.out.println("TDVA " + id + ": request: \n");
			System.out.println("\t>" + new String (ba) + "<");
			out.write(ba);
		}
		catch(IOException e){
			LOG.info("TDVA " + id + ": failed writing, terminate proxy");
			LOG.debug("TDVA " + id + ": failed writing, terminate proxy", e);
			throw e;
		}
	}

	

	private byte[] transformRequest(String request) {

		byte[] ba;
		try{
			ba = request.getBytes(DEFAULT_CHARSET);
		}
		catch(UnsupportedEncodingException e){
			LOG.error("mssing charset " + DEFAULT_CHARSET);
			return new byte[0];
		}
		setLength(ba, request.length());

		return ba;
	}

	private String transformResponse(byte[] inBuffer) {
		String result = null;
		try{
			result = new String(inBuffer, 2, inBuffer.length-2, DEFAULT_CHARSET);
		}
		catch(UnsupportedEncodingException e){
			return null; // should really not happen
		}

		result = result.replaceFirst("<!XML>", "");
		result = result.replaceFirst("<!XML>", "");

		return result;
	}
	
	private String getHostAddress () {
		String hostAdress = socket.getInetAddress().getHostAddress();
		if (StringUtils.isNullorEmpty(hostAdress))
		    hostAdress = "unknown hostaddress";
		
		return hostAdress;
	}
	
	private int computeLength(byte[] headerBuffer) {
		return byteToInt(new Byte(headerBuffer[4]), new Byte(headerBuffer[5]));
	}

	private int byteToInt(Byte pLow, Byte pHigh) {
		int low = pLow.intValue();
		int high = pHigh.intValue();

		if(low < 0){
			low = 256 + low;
		}

		if(high < 0){
			high = 256 + high;
		}

		return low * 256 + high;
	}


	
	// methods from Ojbect
	@Override
	public boolean equals(Object obj) {
		if ( ! (obj instanceof TDVAProxy))
			return false;
		TDVAProxy other = (TDVAProxy) obj;
		
		return id == other.id;
	}


	
	// methods from interface ControlledTask
	@Override
	public void terminateTask() {
		try{
			if (socket != null && socket.isConnected())
			this.socket.close();
		} catch (IOException e) {
			LOG.debug("TDVA " + id + ": could not close socket, ignore exception", e);
		}
	}

	
	
	long getTdvaTimeout() {
		return tdvaTimeout;
	}

	void setTdvaTimeout(long tdvaTimeout) {
		this.tdvaTimeout = tdvaTimeout;
	}

	long getTdvaKeepAliveIntervall() {
		return tdvaKeepAliveIntervall;
	}

	void setTdvaKeepAliveIntervall(long tdvaKeepAliveIntervall) {
		this.tdvaKeepAliveIntervall = tdvaKeepAliveIntervall;
	}

	@Override
	public long getId (){
		return this.id;
	}

	void setId(long id) {
		this.id = id;
	}

	@Override
	public long getTimeout() {
		return tdvaTimeout;
	}
}