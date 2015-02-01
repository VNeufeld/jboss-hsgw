package com.bpcs.suny.tool.xml;

import javax.xml.bind.JAXBException;

import org.w3c.dom.Node;

import com.bpcs.suny.tool.xml.request.getcars.Agency;
import com.bpcs.suny.tool.xml.request.getcars.Travel;

public class HsgwGetCarsXmlRequest extends HsgwXmlRequest{
	
	private Agency agency;
	private Travel travel;

	public HsgwGetCarsXmlRequest(HsgwXmlRequest parent) {
		super(parent.getRequestDocument());
		
		readAgency();
		readTravel();
		
	}

	private void readAgency() {
		Node node = getNode("Agency");
		try {
			agency = new XmlMarshaller().unmarshallFromNode(node, Agency.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void readTravel() {
		Node node = getNode("Travel");
		try {
			travel = new XmlMarshaller().unmarshallFromNode(node, Travel.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Agency getAgency() {
		return agency;
	}

	public Travel getTravel() {
		return travel;
	}
	
}
