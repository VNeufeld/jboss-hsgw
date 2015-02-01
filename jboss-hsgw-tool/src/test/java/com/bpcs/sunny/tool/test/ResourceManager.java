package com.bpcs.sunny.tool.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

public class ResourceManager {

	private final String charset = "UTF-8";
	private final String resourceFolder;

	public ResourceManager(String resourceFolder) {
		this.resourceFolder = resourceFolder;
	}

	public String getRequest(String requestName) throws IOException {
		InputStream stream = ClassLoader.class
				.getResourceAsStream(resourceFolder + requestName + ".xml");
		return IOUtils.toString(stream, charset);
	}

//	public String getRequest(String requestName) throws IOException {
//		InputStream stream = ClassLoader.class.getResourceAsStream(resourceFolder
//				+ requestName + ".xml");
//		return IOUtils.toString(stream, "UTF-8");
//	}

}
