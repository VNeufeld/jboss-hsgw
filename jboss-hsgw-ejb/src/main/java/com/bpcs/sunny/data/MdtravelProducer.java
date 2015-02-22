package com.bpcs.sunny.data;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import com.bpcs.sunny.service.FacadeService;
import com.bpcs.sunny.service.SeasonDAO;
import com.bpcs.sunny.service.UseItemsService;

@RequestScoped
public class MdtravelProducer {

	@Inject
	private Logger log;

	@Inject
	private FacadeService facade;

	@Produces
	public SeasonDAO produceSeasonDAO() {
		SeasonDAO s = new SeasonDAO(facade);
		log.info("produce Season "+s);
		return s;
	}
	
	@Produces
	public UseItemsService produceUseItemsService() {
		UseItemsService s = new UseItemsService(facade);
		log.info("produce Season "+s);
		return s;
	}
	
}
