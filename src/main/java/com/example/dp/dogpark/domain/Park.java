package com.example.dp.dogpark.domain;

import javax.persistence.*;

@Entity
public class Park {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Embedded
	private ParkAddress address;
	
	@Column String name;
	
	@Column
	private String website;

	@Column
	private String gMapsLink;

	@Column
	private Integer numOfDogsCheckedIn;
	
	public Park(String name, ParkAddress address, String website, String gMapsLink) {
		this.name = name;
		this.address = address;
		this.website = website;
		this.gMapsLink = gMapsLink;
		this.numOfDogsCheckedIn = 0;
		
	}

	protected Park() {}
	
	@Override
	public String toString() {
		return "Park [id=" + id + ", address=" + address.toString() + ", name=" + name + ", website=" + website + ", gMapsLink="
				+ gMapsLink + ", numOfDogsCheckedIn=" + numOfDogsCheckedIn + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
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
	
	public Integer getNumOfDogsCheckedIn() {
		return numOfDogsCheckedIn;
	}

	public void setNumOfDogsCheckedIn(Integer dogsToAdd) {
		this.numOfDogsCheckedIn = numOfDogsCheckedIn + dogsToAdd;
	}
	
}
