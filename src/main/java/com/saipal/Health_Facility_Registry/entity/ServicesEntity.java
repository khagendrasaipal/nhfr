package com.saipal.Health_Facility_Registry.entity;

import java.sql.Array;

public class ServicesEntity {

	Array services;

	
	public ServicesEntity(Array services) {
		super();
		this.services = services;
	}


	public ServicesEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Array getServices() {
		return services;
	}

	public void setServices(Array services) {
		this.services = services;
	}
	
}
