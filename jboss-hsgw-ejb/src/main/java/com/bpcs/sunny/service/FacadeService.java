package com.bpcs.sunny.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bpcs.sunny.data.CurrencyCache;
import com.bpcs.sunny.model.BaseScale;
import com.bpcs.sunny.model.CarRateOffer;

@Stateless
public class FacadeService {
	@Inject
	private Logger log;
	
	@Inject
	private CurrencyCache currencyCache;


	@Inject
	private MdtravelServiceFactory mdtravelServiceFactory;
	
	
	public String getFacadeDate(String param) {
		log.info("param "+param);
		
		return " facade "+param + " cur = "+currencyCache.getCurrency("key1");
	}
	
	public Integer  getSeason(String param) {
		log.info("param "+param);
		return 12;
	}

	public List<CarRateOffer> getCarRates(BaseScale scale) {
		List<CarRateOffer> result = new ArrayList<CarRateOffer>();
		
		ICarRatesService carRatesService = mdtravelServiceFactory.getCarRatesService(scale);
		
		List<CarRateOffer> rr = carRatesService.getCarRates(scale);
		
		result.addAll(rr);
		
		
		return result;
	}

}
