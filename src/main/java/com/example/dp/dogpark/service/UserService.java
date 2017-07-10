package com.example.dp.dogpark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dp.dogpark.domain.Dog;
import com.example.dp.dogpark.domain.User;
import com.example.dp.dogpark.repository.DogRepository;
import com.example.dp.dogpark.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	private DogRepository dogRepository;

	@Autowired
	public UserService(UserRepository userRepository, DogRepository dogRepository) {
		this.userRepository = userRepository;
		this.dogRepository = dogRepository;
	}
	
	/**
	 * 
	 * @param email
	 * @param dogs
	 * @return a new User with an empty list of type Dog
	 */
	public User createUser(String email, List<Dog> dogs) {
		return userRepository.save(new User(email, dogs));
	}
	
	public void addDogToUser(Dog dog, User user) {
		user.addDog(dog);
	}
	
	public void removeDogFromUser(Dog dog, User user) {
		user.removeDog(dog);
	}
}
