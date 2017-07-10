package com.example.dp.dogpark.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User {

	@Id
	private String email;
	
	@OneToMany(targetEntity=Dog.class)
	private List<Dog> dogs;

	public User(String email, List<Dog> dogs) {
		this.email = email;
		this.dogs = dogs;
	}
	
	protected User() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Dog> getDogs() {
		return dogs;
	}
	
	public void addDog(Dog dog) {
		this.dogs.add(dog);
	}

	public void removeDog(Dog dog) {
		this.dogs.remove(dog);
	}
}
