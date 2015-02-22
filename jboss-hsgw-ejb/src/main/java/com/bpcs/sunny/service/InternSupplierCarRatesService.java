package com.bpcs.sunny.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bpcs.sunny.model.BaseScale;
import com.bpcs.sunny.model.CarRateOffer;

@Stateless
public class InternSupplierCarRatesService implements ICarRatesService {
	
	@Inject
	private SeasonDAO seasonDAO;

	public List<CarRateOffer> getCarRates(BaseScale scale) {
		
		List<CarRateOffer> result = new ArrayList<CarRateOffer>();
		
		return result;
	}


}
