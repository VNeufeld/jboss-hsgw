package com.bpcs.sunny.tool.test;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bpcs.suny.tool.xml.ResourceManager;
import com.bpcs.suny.tool.xml.XmlMarshaller;
import com.bpcs.suny.tool.xml.config.HsgwConfig;

public class TestConfig {

	private String resourceFolder = "C:/Temp/sunny/config";

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void testParseXml() {

		try {

			String xmlConfig = new ResourceManager(resourceFolder)
					.readFile("Config.xml");
			Assert.assertNotNull(xmlConfig);

			HsgwConfig obj = new XmlMarshaller().unmarshallFromXML(xmlConfig,
					HsgwConfig.class);
			Assert.assertNotNull(obj);
			Assert.assertNotNull(obj.getRequestorConfig());
			Assert.assertNotNull(obj.getTdvaConfig());
			
			Assert.assertEquals("sunny",  obj.getName());
			Assert.assertEquals("http://127.0.0.1:5670",  obj.getRequestorConfig().getPath());
			Assert.assertEquals(true,  obj.getRequestorConfig().isActive());
			Assert.assertEquals("value 0",  obj.getRequestorConfig().getContent());

			Assert.assertEquals("http://127.0.0.1:5920",  obj.getTdvaConfig().getPath());
			
			Assert.assertEquals("123,345",  obj.getRequestorConfig().getDemobj_excepted());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
}
