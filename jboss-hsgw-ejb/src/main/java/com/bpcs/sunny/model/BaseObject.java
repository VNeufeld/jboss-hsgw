package com.bpcs.sunny.model;

public abstract class BaseObject {
	protected final Integer id;
	
	protected String name;

	public BaseObject(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
