package com.bpcs.sunny.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.bpcs.sunny.model.BaseScale;
import com.bpcs.sunny.model.InternSupplierScale;

@Stateless
public class MdtravelServiceFactory {
	
	@EJB(beanName = "InternSupplierCarRatesService")
	private ICarRatesService internSupplierCarRatesService;

	@EJB(beanName = "ExternSupplierCarRatesService")
	private ICarRatesService externSupplierCarRatesService;
	
	public ICarRatesService getCarRatesService(BaseScale scale) {
		if( scale instanceof InternSupplierScale)
			return internSupplierCarRatesService;
		else
			return externSupplierCarRatesService;
		
		
	}

}
