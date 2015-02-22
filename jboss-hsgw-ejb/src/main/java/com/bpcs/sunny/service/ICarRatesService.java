package com.bpcs.sunny.service;

import java.util.List;

import com.bpcs.sunny.model.BaseScale;
import com.bpcs.sunny.model.CarRateOffer;


public interface ICarRatesService {
	
	List<CarRateOffer> getCarRates(BaseScale scale);

}
