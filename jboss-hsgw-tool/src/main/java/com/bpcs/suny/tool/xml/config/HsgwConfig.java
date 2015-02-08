package com.bpcs.suny.tool.xml.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * 
 * 
 * @author Valeri
 * 
 * <Config name ="sunny">
	<Requestor name="Requestor" path="http://127.0.0.1:5670" active="1" demobj="123,345">value 0</Requestor>
	<TDVA name="CDM TDVA" path="http://127.0.0.1:5920" active="1"/>
   </Config>
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Config")
public class HsgwConfig {
	
    @XmlAttribute(name = "name")
	private String name;
	
    @XmlElement(name = "Requestor", required = true)
	private RequestorConfigXml requestorConfig;
    
    @XmlElement(name = "TDVA", required = true)
	private TdvaConfig tdvaConfig;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public RequestorConfigXml getRequestorConfig() {
		return requestorConfig;
	}
	public void setRequestorConfig(RequestorConfigXml requestorConfig) {
		this.requestorConfig = requestorConfig;
	}
	public TdvaConfig getTdvaConfig() {
		return tdvaConfig;
	}
	public void setTdvaConfig(TdvaConfig tdvaConfig) {
		this.tdvaConfig = tdvaConfig;
	}

}
