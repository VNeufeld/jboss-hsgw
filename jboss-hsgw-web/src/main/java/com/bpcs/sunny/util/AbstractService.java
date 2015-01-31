package com.bpcs.sunny.util;

import com.bpcs.sunny.service.FacadeService;

public class AbstractService {
	protected final FacadeService facade;
	
	public AbstractService(FacadeService facade) {
		super();
		this.facade = facade;
	}


}
