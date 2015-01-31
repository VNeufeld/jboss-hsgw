package com.bpcs.sunny.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bpcs.sunny.util.ServiceFactory;

@WebServlet("/SunnyXml")
public class XmlServlet extends HttpServlet{
	 @Inject
	 private Logger log;
	 
	 @Inject
	 private ServiceFactory serviceFactory;
	 
	 @Inject
	 private SessionController sessionController;
	 
	 private static  Logger xlog = Logger.getLogger(XmlServlet.class.getName());
	
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		
	}

}
