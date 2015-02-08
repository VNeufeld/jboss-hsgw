package com.bpcs.suny.tool.xml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
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

	public String readFile(String requestName) throws IOException {
		String path = FilenameUtils.concat(resourceFolder, requestName); 
		File file = new File(path);
		return FileUtils.readFileToString(file, charset);
	}
	
//	public String getRequest(String requestName) throws IOException {
//		InputStream stream = ClassLoader.class.getResourceAsStream(resourceFolder
//				+ requestName + ".xml");
//		return IOUtils.toString(stream, "UTF-8");
//	}

}
