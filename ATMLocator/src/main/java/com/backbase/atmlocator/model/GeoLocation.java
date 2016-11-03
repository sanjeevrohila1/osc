package com.backbase.atmlocator.model;

import java.math.BigDecimal;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoLocation {

	private BigDecimal lat;
	private BigDecimal lng;

	public GeoLocation(BigDecimal latitude, BigDecimal longitude) {
		super();
		this.lat = latitude;
		this.lng = longitude;
	}

	public GeoLocation() {

	}

	public BigDecimal getLat() {
		return lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public BigDecimal getLng() {
		return lng;
	}

	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}

}
