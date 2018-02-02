package com.example.dp.dogpark.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dp.dogpark.domain.Dog;
import com.example.dp.dogpark.domain.DogSize;
import com.example.dp.dogpark.domain.User;
import com.example.dp.dogpark.repository.DogRepository;

@Service
public class DogService {
	
	private DogRepository dogRepository;

	@Autowired
	public DogService(DogRepository dogRepository) {
		this.dogRepository = dogRepository;
	}
	
	/**
	 * 
	 * @param name
	 * @param breed
	 * @param size
	 * @param characteristics
	 * Persist dog to DB, and 
	 * @return new dog
	 */
	public Dog createDog(String name, User user, String breed, DogSize size, ArrayList<String> characteristics) {
		return dogRepository.save(new Dog(name, user, breed, size, characteristics));
	}
	
	public Iterable<Dog> findAll() {
		return dogRepository.findAll();
	}
	
	public long total() {
		return dogRepository.count();
	}

}
