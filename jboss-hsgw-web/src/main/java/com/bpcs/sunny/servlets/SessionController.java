package com.bpcs.sunny.servlets;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.w3c.dom.Document;

import com.bpcs.sunny.util.ServiceFactory;

public class SessionController {
	@Inject
	private Logger log;

	@Inject
	private ServiceFactory serviceFactory;

	public String workXml(String xml) {
		
		Document doc = parseXml(xml);
		

		String result = serviceFactory.createService(1).execute(xml);
		return result;
	}

	private Document parseXml(String xml) {
		// TODO Auto-generated method stub
		return null;
	}

	@PostConstruct
	public void init() {
		log.info("@PostConstruct");
	}
}
