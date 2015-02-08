package com.bpcs.sunny.service;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import com.bpcs.suny.tool.xml.ResourceManager;
import com.bpcs.suny.tool.xml.XmlMarshaller;
import com.bpcs.suny.tool.xml.config.HsgwConfig;

@ApplicationScoped
public class ConfigService {
	private String resourceFolder = "C:/Temp/sunny/config";

	private HsgwConfig config;

	private static Logger xlog = Logger
			.getLogger(ConfigService.class.getName());
	

	@PostConstruct
	private void init() {
		xlog.info("ConfigService init");

		try {
			String xmlConfig = new ResourceManager(resourceFolder)
					.readFile("Config.xml");

			config = new XmlMarshaller().unmarshallFromXML(xmlConfig,
					HsgwConfig.class);

			xlog.log(Level.INFO, " Config TDVA path = "
					+ config.getTdvaConfig().getPath());

			xlog.info("ConfigService read config successfull..");

		} catch (IOException e) {
			xlog.log(Level.SEVERE, e.getMessage(), e);
		}

	}

	public HsgwConfig getHsgwConfig() {
		return config;
	}

	public String getTdvaPath() {
		return config.getTdvaConfig().getPath();
	}

}
