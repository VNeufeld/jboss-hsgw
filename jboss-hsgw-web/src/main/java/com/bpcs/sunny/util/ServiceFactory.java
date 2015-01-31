package com.bpcs.sunny.util;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.bpcs.sunny.service.FacadeService;

@ApplicationScoped
public class ServiceFactory {

	@Inject
	private Logger log;

	@Inject
	private FacadeService facade;
	
	@Inject
	private GetCarsService getCarsService;
	
	@Inject
	private BookingService bookingService;


	public IHsgwService createService(final int service_id) {
		switch (service_id) {
		case 1:
			return getCarsService;
		case 2:
			return bookingService;
		}

		//GetCarsService service = new GetCarsService(facade);
		return getCarsService;

	}

	@PostConstruct
	public void init() {
		log.info("@PostConstruct"); 	
	}
}
