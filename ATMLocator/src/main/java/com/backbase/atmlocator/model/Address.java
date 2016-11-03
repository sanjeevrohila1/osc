package com.backbase.atmlocator.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

	private String city;
	private String street;
	private String housenumber;
	private String postalcode;
	private GeoLocation geoLocation;
	

	public Address(String city, String street, String housenumber, String postalcode, GeoLocation geoLocation) {
		super();
		this.city = city;
		this.street = street;
		this.housenumber = housenumber;
		this.postalcode = postalcode;
		this.geoLocation = geoLocation;
		
	}
	
	

	public void setCity(String city) {
		this.city = city;
	}



	public void setStreet(String street) {
		this.street = street;
	}



	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}



	public void setpostalcode(String postalcode) {
		this.postalcode = postalcode;
	}



	public void setGeolocation(GeoLocation geoLocation) {
		this.geoLocation = geoLocation;
	}

	public Address() {
		super();
	}



	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public String getHousenumber() {
		return housenumber;
	}

	public String getpostalcode() {
		return postalcode;
	}

	public GeoLocation getGeoLocation() {
		return geoLocation;
	}

}
