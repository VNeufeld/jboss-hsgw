package com.bpcs.suny.tool.xml;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.bpcs.suny.tool.xml.request.Request;
import com.bpcs.suny.tool.xml.request.RequestorRequest;

public class HsgwXmlRequest {
	
	private Document requestDocument;
	private RequestorRequest requestorRequest;
	
	private static String namespace = "common"; 

	public HsgwXmlRequest(Document document) {
		try {
			requestDocument = document;
			requestorRequest =  getRequestorRequest();
			
		} catch ( JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public HsgwXmlRequest(String xml) {
		try {
			requestDocument = loadXMLFrom(xml);
			requestorRequest =  getRequestorRequest();
			
		} catch (TransformerException | JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Integer getDemandedObject() {
		return Integer.valueOf(requestorRequest.getRequestorRequestContent().getRequest().getDemandedObjects().getDemandedObject());
	}
	
	public int getDemandedObjectFromNode() {
		NodeList nd = requestDocument.getElementsByTagName("DemandedObject");
		String s =nd.item(0).getTextContent();
		return Integer.valueOf(s);
		
	}
	
	public Node getAdministrationNode() {
		NodeList nd = requestDocument.getElementsByTagName("Administration");
		return nd.item(0);
	}

	public Node getNode(String name) {
		NodeList nd = requestDocument.getElementsByTagName(name);
		return nd.item(0);
	}
	
	public Node getRequestNode() {
		NodeList nd = requestDocument.getElementsByTagName("Request");
		return nd.item(0);
	}
	
	public Request getRequest() throws JAXBException {
		Node requestNode = getRequestNode();

		JAXBContext jaxbContextRequest = JAXBContext
				.newInstance(Request.class);
		Unmarshaller unmarshaller = jaxbContextRequest.createUnmarshaller();

		JAXBElement<Request> obj1 = unmarshaller.unmarshal(requestNode,
				Request.class);
		return obj1.getValue();
	}
	
	public Request getRequestX() throws JAXBException {
		
		return requestorRequest.getRequestorRequestContent().getRequest();
	}

	public String  getSessionId() throws JAXBException {
		
		return requestorRequest.getRequestorName().getSessionId();
	}


	private RequestorRequest getRequestorRequest() throws JAXBException {
		Node requestNode = requestDocument.getDocumentElement();

		JAXBContext jaxbContextRequest = JAXBContext
				.newInstance(RequestorRequest.class);
		Unmarshaller unmarshaller = jaxbContextRequest.createUnmarshaller();

		JAXBElement<RequestorRequest> obj1 = unmarshaller.unmarshal(requestNode,
				RequestorRequest.class);
		return obj1.getValue();
	}
	
	private static Document loadXMLFrom(String xml) throws TransformerException {
		Source source = new StreamSource(new StringReader(xml));
		DOMResult result = new DOMResult();
		TransformerFactory.newInstance().newTransformer()
				.transform(source, result);
		return (Document) result.getNode();
	}

	public Document getRequestDocument() {
		return requestDocument;
	}

}
