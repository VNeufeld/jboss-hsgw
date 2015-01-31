package com.bpcs.sunny.servlets;

import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;

import org.jdom2.JDOMException;
import org.jdom2.output.DOMOutputter;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.bpcs.sunny.util.ServiceFactory;
import com.bpcs.suny.tool.xml.JDom2Helper;

@RequestScoped
public class SessionController {
	@Inject
	private Logger log;

	@Inject
	private ServiceFactory serviceFactory;

	public String workXml(String xml) {

		org.jdom2.Document jdom2 = null;
		try {
			Document doc = loadXMLFrom(xml);

			jdom2 = JDom2Helper.getJDom2FromW3cDom(doc);

			DOMOutputter domOutputer = new DOMOutputter();
			// create the w3c Document from the JDOM2 Document
			org.w3c.dom.Document dom = domOutputer.output(jdom2);

		} catch (TransformerException | JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String result = serviceFactory.createService(1).execute(xml);
		return result;
	}

	private Document parseXml(String xml) {
		// TODO Auto-generated method stub
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// we are interested in making it namespace aware.
		factory.setNamespaceAware(true);
		try {
			DocumentBuilder dombuilder = factory.newDocumentBuilder();
			org.w3c.dom.Document w3cDocument = dombuilder.parse(xml);
			return w3cDocument;
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static Document loadXMLFrom(String xml) throws TransformerException {
		Source source = new StreamSource(new StringReader(xml));
		DOMResult result = new DOMResult();
		TransformerFactory.newInstance().newTransformer()
				.transform(source, result);
		return (Document) result.getNode();
	}

	@PostConstruct
	public void init() {
		log.info("@PostConstruct");
	}
}
