package com.bpcs.sunny.util;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.bpcs.sunny.data.CurrencyCache;
import com.bpcs.sunny.service.FacadeService;
import com.bpcs.suny.tool.xml.HsgwXmlRequest;

@RequestScoped
public class BookingService /* extends AbstractService */ implements IHsgwService {

	@Inject
	private FacadeService facade;
	
	@Inject
	private CurrencyCache currencyCache;
	
	@Inject
	private Logger log;

//	public GetCarsService(FacadeService facade) {
//		super(facade);
//	}

	@Override
	public String  execute(String xml) {
		StringBuilder sb = new StringBuilder();
		log.info("BookingService execute " + this + " xml = "+xml);
		
		sb.append(this.getClass().getSimpleName());
		sb.append(" ");
		sb.append(this.toString());
		sb.append(" ");
		sb.append(xml);
		sb.append(" ");
		sb.append(facade.getFacadeDate(xml));
		
		sb.append(" currencyCache " + currencyCache.toString());
		sb.append(" ");
		sb.append(currencyCache.getCurrency("key1"));
		
		return sb.toString();

	}

	@Override
	public String execute(HsgwXmlRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
