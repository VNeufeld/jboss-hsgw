package com.bpcs.sunny.data;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.inject.Inject;

@Singleton
public class CurrencyCache {
	
	private Map<String,String> currencyMap;

	@Inject
	private Logger log;

	@PostConstruct
	public void init() {
		log.info("CurrencyCache.init");
		
		currencyMap = new HashMap<String,String>();
		currencyMap.put("key1", "EUR");

	}
	
	public String getCurrency(String key) {
		return currencyMap.get(key);
	}

}
