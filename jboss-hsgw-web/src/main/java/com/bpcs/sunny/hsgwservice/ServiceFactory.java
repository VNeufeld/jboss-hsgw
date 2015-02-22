package com.bpcs.sunny.hsgwservice;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
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
		case 10002:
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
