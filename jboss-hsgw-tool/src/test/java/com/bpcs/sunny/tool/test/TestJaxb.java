package com.bpcs.sunny.tool.test;

import static org.junit.Assert.fail;

import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;

//import com.bpcs.sunny.hsgwservice.HsgwGetCarsXmlRequest;
import com.bpcs.suny.tool.xml.HsgwXmlRequest;
import com.bpcs.suny.tool.xml.ResourceManager;
import com.bpcs.suny.tool.xml.request.Administration;
import com.bpcs.suny.tool.xml.request.Request;

public class TestJaxb {

	private String resourceFolder = "/sunny/";

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

			String xmlRequest = new ResourceManager(resourceFolder)
					.getRequest("BookingRequest");
			Assert.assertNotNull(xmlRequest);

			HsgwXmlRequest hsgwXmlRequest = new HsgwXmlRequest(xmlRequest);
			int demOb = hsgwXmlRequest.getDemandedObject();
			Assert.assertEquals(19999, demOb);

			Node adminNode = hsgwXmlRequest.getAdministrationNode();

			JAXBContext jaxbContext = JAXBContext
					.newInstance(Administration.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

			JAXBElement<Administration> obj = unmarshaller.unmarshal(adminNode,
					Administration.class);
			Administration adm = obj.getValue();
			long opid = adm.getOperatorId();
			Assert.assertEquals(1, opid);

			Request request = hsgwXmlRequest.getRequest();
			Assert.assertEquals(5, request.getCalledFrom());
			opid = request.getAdministration().getOperatorId();
			Assert.assertEquals(1, opid);

		} catch (IOException | JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// FileUtils.readFileToString(file)
	}
	
	@Test
	public void testReadBookingRequest() {

		try {

			String xmlRequest = new ResourceManager(resourceFolder)
					.getRequest("BookingRequest");
			Assert.assertNotNull(xmlRequest);

			HsgwXmlRequest hsgwXmlRequest = new HsgwXmlRequest(xmlRequest);
			Request request = hsgwXmlRequest.getRequest();
			Assert.assertEquals(19999, request.getDemandedObjects().getDemandedObject());
			Assert.assertEquals(5, request.getCalledFrom());
			long opid = request.getAdministration().getOperatorId();
			Assert.assertEquals(1, opid);

		} catch (IOException | JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// FileUtils.readFileToString(file)
	}
	
	@Test
	public void testReadGetCarsRequest() {

		try {

			String xmlRequest = new ResourceManager(resourceFolder)
					.getRequest("getCarsExternNet_231255");
			Assert.assertNotNull(xmlRequest);

			HsgwXmlRequest hsgwXmlRequest = new HsgwXmlRequest(xmlRequest);
			Request request = hsgwXmlRequest.getRequestX();
			Assert.assertEquals(10002, request.getDemandedObjects().getDemandedObject());
			Assert.assertEquals(5, request.getCalledFrom());
			long opid = request.getAdministration().getOperatorId();
			Assert.assertEquals(200000, opid);

			String sessionId = hsgwXmlRequest.getSessionId();
			Assert.assertEquals("12345", sessionId);
			
////			HsgwGetCarsXmlRequest getCarsXmlRequest = new HsgwGetCarsXmlRequest(hsgwXmlRequest);
//			Assert.assertEquals("12345", sessionId);
//			
//			Assert.assertEquals(231255, getCarsXmlRequest.getTravel().getPickUpSupplierId().intValue());
//			
//			Assert.assertEquals(18381, getCarsXmlRequest.getAgency().getAgencyId().intValue());
//			
//			getCarsXmlRequest.getTravel().getPickUpSupplierId();
			
		} catch (IOException | JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// FileUtils.readFileToString(file)
	}
	
}
