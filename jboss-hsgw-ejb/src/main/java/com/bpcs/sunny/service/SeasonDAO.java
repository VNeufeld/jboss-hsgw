package com.bpcs.sunny.service;

public class SeasonDAO {
	
	private final FacadeService facade;
	
	public SeasonDAO ( final FacadeService facade ) {
		this.facade = facade;
	}
	
	public Integer  getSeason() {
		return facade.getSeason("test");
	}
	
}
