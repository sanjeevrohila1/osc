package com.backbase.atmlocator.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ATM {
	
	private Address address;
	private Double distance;
	private String type;

	
	

	public ATM(Address address, Double distance, String type) {
		super();
		this.address = address;
		this.distance = distance;
		this.type = type;
	}

	public ATM() {
		super();
	}

	public Address getAddress() {
		return address;
	}
	
	public boolean belongsTo(String cityName) {
		return this.getAddress().getCity().equalsIgnoreCase(cityName) ? true : false;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Double getDistance() {
		return distance;
	}

	public String getType() {
		return type;
	}
	
	

}
