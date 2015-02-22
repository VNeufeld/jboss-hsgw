package com.bpcs.sunny.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bpcs.sunny.model.BaseScale;
import com.bpcs.sunny.model.CarRateOffer;
import com.bpcs.sunny.model.InternSupplierScale;
import com.bpcs.sunny.model.UseItems;

@Stateless
public class InternSupplierCarRatesService implements ICarRatesService {
	
	@Inject
	private SeasonDAO seasonDAO;

	@Inject
	private UseItemsService useItemsService;
	
	public List<CarRateOffer> getCarRates(BaseScale scale) {
		
		InternSupplierScale internSupplierScale = (InternSupplierScale) scale;
		
		List<CarRateOffer> result = new ArrayList<CarRateOffer>();
		
		seasonDAO.getSeason();
		
		UseItems derivated = useItemsService.getDerivatedUseItems(internSupplierScale.getSupplier(), internSupplierScale.getServiceCatalog());
		
		carRates = getCarRatesIntern(internSupplierScale,derivated);

		Currency currOperator = internSupplierScale.getOperator().getCurrency();
		
		if ( COST_RATES) {
			Currency currSupplier = internSupplierScale.getSupplier().getCurrency();
			applyCostPlusRules(carRates,derivated,internSupplierScale);
			
		}
		
		
		
		
		
		return result;
	}

	private void getCarRatesIntern(InternSupplierScale internSupplierScale,
			UseItems derivated) {
		
	}


}
