package com.bpcs.sunny.hsgwservice;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.bpcs.sunny.model.BaseScale;
import com.bpcs.sunny.model.CarRateOffer;
import com.bpcs.sunny.model.InternSupplierScale;
import com.bpcs.sunny.model.ServiceCatalog;
import com.bpcs.sunny.model.Station;
import com.bpcs.sunny.model.Supplier;
import com.bpcs.sunny.service.FacadeService;
import com.bpcs.sunny.service.SeasonDAO;
import com.bpcs.suny.tool.xml.HsgwXmlRequest;
import com.bpcs.suny.tool.xml.HsgwXmlResponse;

@RequestScoped
public class GetCarsService extends AbstractService implements IHsgwService {

	private static Logger xlog = Logger.getLogger(GetCarsService.class.getName());
	
	@Inject
	private FacadeService facade;
	
	@Inject
	private SeasonDAO seasonDAO;

	
	@Inject
	private Logger log;

	@Override
	public String  execute(String xml) {
		StringBuilder sb = new StringBuilder();
		xlog.info("GetCarsService execute " + this + " xml = "+xml);
		
		sb.append(this.getClass().getSimpleName());
		sb.append(" ");
		sb.append(this.toString());
		sb.append(" ");
		sb.append(xml);
		sb.append(" ");
		sb.append(facade.getFacadeDate(xml));
		sb.append(" Season ");
		sb.append(seasonDAO.getSeason());
		return sb.toString();

	}

	@Override
	public HsgwXmlResponse execute(HsgwXmlRequest request) {
		
		xlog.info("Season = "+seasonDAO.getSeason());
		
		HsgwGetCarsXmlRequest getCarsRequest = new HsgwGetCarsXmlRequest(request) ;
		
		List<BaseScale> scales = createScales(getCarsRequest);
		
		HsgwGetCarsXmlResponse response = new HsgwGetCarsXmlResponse();
		
		for ( BaseScale scale : scales ) {
			List<CarRateOffer> offers = facade.getCarRates(scale);
			
			response.addOffers(offers);
		}
		
		return response;
	}

	private List<BaseScale> createScales(HsgwGetCarsXmlRequest getCarsRequest) {
		
		List<BaseScale> scales = new ArrayList<BaseScale>(); 
		
		InternSupplierScale scale = new InternSupplierScale();
		
		scale.setCheckInDate(Calendar.getInstance());

		Calendar pickup = Calendar.getInstance();
		pickup.set(2015, 4, 10);
		scale.setPickup(pickup);

		Calendar dropoff = Calendar.getInstance();
		pickup.set(2015, 4, 17);
		scale.setDropoff(dropoff);
		

		scale.setSupplier(new Supplier(11));
		scale.setPickStation(new Station(11));
		scale.setDropStation(new Station(11));
		scale.setServiceCatalog(new ServiceCatalog(1));;
		
		scales.add(scale);
		return scales;
	}

}
