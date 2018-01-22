package com.example.dp.dogpark.domain;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dog")
public class Dog {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="breed")
	private String breed;
	
	@Column(name="dogSize")
	private DogSize dogSize;
	
	@Column(name="characteristics")
	private ArrayList<String> characteristics;
	
//	@ManyToOne
//	private User user;

	public Dog(
			String name,
			String breed, 
			DogSize size, 
			ArrayList<String> characteristics) {
		this.name = name;
		this.breed = breed;
		this.dogSize = size;
		this.characteristics = characteristics;
	}
	
	@Override
	public String toString() {
		return "Dog [id=" + id + ", name=" + name + ", breed=" + breed + ", dogSize=" + dogSize + ", characteristics="
				+ characteristics.toString() + "]";
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

	public ArrayList<String> getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(ArrayList<String> characteristics) {
		this.characteristics = characteristics;
	}
	
}
