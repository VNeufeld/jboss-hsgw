package com.bpcs.sunny.service;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bpcs.sunny.data.CurrencyCache;

@Stateless
public class FacadeService {
	@Inject
	private Logger log;
	
	@Inject
	private CurrencyCache currencyCache;
	
	public String getFacadeDate(String param) {
		log.info("param "+param);
		
		return " facade "+param + " cur = "+currencyCache.getCurrency("key1");
	}
}
