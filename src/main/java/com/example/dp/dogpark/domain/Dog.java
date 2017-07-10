package com.example.dp.dogpark.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Dog {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private String breed;
	
	@Column
	private DogSize dogSize;
	
	@Column
	private String[] characteristics;

	public Dog(
			String name,
			String breed, 
			DogSize size, 
			String[] characteristics) {
		this.name = name;
		this.breed = breed;
		this.dogSize = size;
		this.characteristics = characteristics;
	}
	
	protected Dog() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public DogSize getDogSize() {
		return dogSize;
	}

	public void setDogSize(DogSize size) {
		this.dogSize = size;
	}

	public String[] getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(String[] characteristics) {
		this.characteristics = characteristics;
	}
	
}
