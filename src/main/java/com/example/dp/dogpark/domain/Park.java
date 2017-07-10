package com.example.dp.dogpark.domain;

import javax.persistence.*;

@Entity
public class Park {

	@Id
	private String website;
	
	@Embedded
	private ParkAddress address;
	
	@Column
	private String gMapsLink;
	
	public Park(ParkAddress address, String website, String gMapsLink) {
		this.address = address;
		this.website = website;
		this.gMapsLink = gMapsLink;
	}

	protected Park() {}
	
	public ParkAddress getAddress() {
		return address;
	}

	public void setAddress(ParkAddress address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getgMapsLink() {
		return gMapsLink;
	}

	public void setgMapsLink(String gMapsLink) {
		this.gMapsLink = gMapsLink;
	}
	
	
}
