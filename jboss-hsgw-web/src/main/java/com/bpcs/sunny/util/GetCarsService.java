package com.bpcs.sunny.util;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.bpcs.sunny.service.FacadeService;

@RequestScoped
public class GetCarsService /* extends AbstractService */ implements IHsgwService {

	private static Logger xlog = Logger.getLogger(GetCarsService.class.getName());
	
	@Inject
	private FacadeService facade;

	
	@Inject
	private Logger log;

//	public GetCarsService(FacadeService facade) {
//		super(facade);
//	}

	@Override
	public String  execute(String xml) {
		StringBuilder sb = new StringBuilder();
		xlog.info("GetCarsService execute " + this + " xml = "+xml);
		
		sb.append(this.getClass().getSimpleName());
		sb.append(" ");
		sb.append(this.toString());
		sb.append(" ");
		sb.append(xml);
		sb.append(" ");
		sb.append(facade.getFacadeDate(xml));
		
		return sb.toString();

	}

}
