/**
 * 
 */
package com.bpcs.sunny.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Valeri
 *
 */
public class ExternSupplierScale extends BaseScale {

	private List<ServiceCatalog> serviceCatalogs = new ArrayList<ServiceCatalog>();

	public ExternSupplierScale() {
	}

	public List<ServiceCatalog> getServiceCatalogs() {
		return serviceCatalogs;
	}

}
