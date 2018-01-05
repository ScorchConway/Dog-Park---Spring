package com.example.dp.dogpark.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ParkAddress {
	
	@Override
	public String toString() {
		return "ParkAddress [street=" + street + ", streetLineTwo=" + streetLineTwo + ", city=" + city + ", state="
				+ state + ", zipcode=" + zipcode + "]";
	}

	@Column
	private String street;
	
	@Column
	private String streetLineTwo;
	
	@Column
	private String city;
	
	@Column
	private String state;
	
	@Column 
	int zipcode;

	public ParkAddress(String street, String streetLineTwo, String city, String state, int zipcode) {
		this.street = street;
		this.streetLineTwo = streetLineTwo;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	
	public ParkAddress(){}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetLineTwo() {
		return streetLineTwo;
	}

	public void setStreetLineTwo(String streetLineTwo) {
		this.streetLineTwo = streetLineTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	
}
