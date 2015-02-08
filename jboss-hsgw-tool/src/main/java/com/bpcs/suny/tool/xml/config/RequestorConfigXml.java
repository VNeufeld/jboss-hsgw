package com.bpcs.suny.tool.xml.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Requestor")
public class RequestorConfigXml extends ConnectionProperty {

	@XmlAttribute(name = "demobj")
	private String demobj_excepted;

	public String getDemobj_excepted() {
		return demobj_excepted;
	}

	public void setDemobj_excepted(String demobj_excepted) {
		this.demobj_excepted = demobj_excepted;
	}


}
