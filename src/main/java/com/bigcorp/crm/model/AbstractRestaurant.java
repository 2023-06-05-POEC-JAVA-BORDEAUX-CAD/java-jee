package com.bigcorp.crm.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractRestaurant {
	
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
