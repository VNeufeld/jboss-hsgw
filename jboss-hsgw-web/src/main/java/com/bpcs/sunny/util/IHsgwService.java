package com.bpcs.sunny.util;

import com.bpcs.suny.tool.xml.HsgwXmlRequest;

public interface IHsgwService {
	
	String execute(String xml);

	String execute(HsgwXmlRequest request);
	
}
