package com.bpcs.sunny.service;

import java.util.List;

import javax.ejb.Stateless;

import com.bpcs.sunny.model.BaseScale;
import com.bpcs.sunny.model.CarRateOffer;

@Stateless
public class ExternSupplierCarRatesService implements ICarRatesService {

	@Override
	public List<CarRateOffer> getCarRates(BaseScale scale) {
		// TODO Auto-generated method stub
		return null;
	}


}
