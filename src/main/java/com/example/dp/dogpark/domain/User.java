package com.example.dp.dogpark.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String email;
	
	@OneToMany
	private List<Dog> dogs;

	public User(String email, ArrayList<Dog> dogs) {
		this.email = email;
		this.dogs = dogs;
	}
	
	@Override
	public String toString() {
		return "User [email=" + email + ", dogs=" + dogs + "]";
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
