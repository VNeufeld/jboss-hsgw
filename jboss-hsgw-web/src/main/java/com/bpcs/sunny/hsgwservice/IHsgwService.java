package com.bpcs.sunny.hsgwservice;

import com.bpcs.suny.tool.xml.HsgwXmlRequest;
import com.bpcs.suny.tool.xml.HsgwXmlResponse;

public interface IHsgwService {
	
	String execute(String xml);

	HsgwXmlResponse execute(HsgwXmlRequest request);
	
}
