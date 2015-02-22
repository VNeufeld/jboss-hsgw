package com.bpcs.sunny.data;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import com.bpcs.sunny.service.FacadeService;
import com.bpcs.sunny.service.SeasonDAO;

@RequestScoped
public class SeasonProducer {

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
}
