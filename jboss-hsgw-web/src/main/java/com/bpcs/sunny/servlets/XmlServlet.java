package com.bpcs.sunny.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bpcs.sunny.hsgwservice.ServiceFactory;

@WebServlet("/SunnyXml")
public class XmlServlet extends HttpServlet{
    public static final String CRLF = "\r\n";
	
	 @Inject
	 private Logger log;
	 
	 @Inject
	 private ServiceFactory serviceFactory;
	 
	 @Inject
	 private SessionController sessionController;
	 
	 
	 
	 private static  Logger xlog = Logger.getLogger(XmlServlet.class.getName());

	 private static  Logger LOG = Logger.getLogger(XmlServlet.class.getName());
	
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	static String PAGE_HEADER = "<html><head /><body>";

	static String PAGE_FOOTER = "</body></html>";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		log.info(" Do Get");
		log.warning("warning Get");
		log.fine("fine Get");
		
		xlog.info("local log vvvvv");
		
		int service_id = Integer.valueOf(req.getParameter("id"));
		String xml = req.getParameter("xml");
		
		String result = sessionController.workXml(xml);
		
		String result1 = serviceFactory.createService(service_id).execute(xml);
		
		PrintWriter writer = resp.getWriter();

	      writer.println(PAGE_HEADER);

	      writer.println("<h1>" +"" +result + " __ "   + "</h1>");

	      writer.println(PAGE_FOOTER);

	      writer.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		this.processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String encodingOI = "UTF-8";

		LOG.info("Full: " + request.toString());
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String xml = "";
		String encoding = request.getCharacterEncoding();
		if(null == encoding || "".equals(encoding)){
			// use Default/configured encoding
			request.setCharacterEncoding(encodingOI);
		}
		Enumeration<String> parameterNames = request.getParameterNames();

		if(request.getParameterMap().containsKey("Message")){

			xml = request.getParameter("Message");
			LOG.info("Param Message Received Request: " + xml);

		}

		else if(!parameterNames.hasMoreElements()){
			BufferedReader br = request.getReader();
			String line = null;
			StringBuffer envelope = new StringBuffer();
			while((line = br.readLine()) != null){
				envelope.append(line);
			}
			br.close();

			xml = new String(envelope);
			if(xml.indexOf("filename=") > 0 && xml.indexOf("Content-Type:") > 0){
				xml = xml.substring(xml.indexOf("<?xml version"), xml.indexOf("</RequestorRequest>") + 19);
				LOG.info("File Received Request: " + xml);
			}
			else{
				LOG.info("Body Received Request: " + xml);
			}
		}
		String result = sessionController.workXml(xml);
		
		this.sendFinalResponse(response, result);

		out.close();
	}

	protected void sendFinalResponse(HttpServletResponse pResponse, String pXMLResponse) {
		PrintWriter out = null;
		
		try{
			pResponse.setContentType("text/xml");
			pResponse.setCharacterEncoding("UTF-8");
			//pResponse.setContentLength(pXMLResponse.getOutputString().getBytes("UTF-8").length);

			out = pResponse.getWriter();

			out.write(CRLF);
			out.write(CRLF);
			out.flush();

		}
		catch(Exception e){
			LOG.severe(e.getMessage());
		}

		finally{
			if(out != null){
				out.close();
			}
		}
	}
	
}
