package com.bpcs.sunny.model;

import java.util.Calendar;

public abstract class BaseScale {
	
	private Calendar pickup;
	private Calendar dropoff;
	private Calendar checkInDate;
	
	private Supplier supplier;
	
	private Station pickStation;

	private Station dropStation;
	
	private Operator operator;

	public Calendar getPickup() {
		return pickup;
	}

	public void setPickup(Calendar pickup) {
		this.pickup = pickup;
	}

	public Calendar getDropoff() {
		return dropoff;
	}

	public void setDropoff(Calendar dropoff) {
		this.dropoff = dropoff;
	}

	public Calendar getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Calendar checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Station getPickStation() {
		return pickStation;
	}

	public void setPickStation(Station pickStation) {
		this.pickStation = pickStation;
	}

	public Station getDropStation() {
		return dropStation;
	}

	public void setDropStation(Station dropStation) {
		this.dropStation = dropStation;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

}
