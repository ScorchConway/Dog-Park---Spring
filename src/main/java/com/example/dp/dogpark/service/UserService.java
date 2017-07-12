package com.example.dp.dogpark.service;

import java.util.ArrayList;

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
	 */
	public User createUser(String email, ArrayList<Dog> dogs) {
		return userRepository.save(new User(email, dogs));
	}
	
	public void addDogToUser(Dog dog, User user) {
		user.addDog(dog);
	}
	
	public void removeDogFromUser(Dog dog, User user) {
		user.removeDog(dog);
		dogRepository.delete(dog);
	}
	
	public long total() {
		return userRepository.count();
	}
	
	public String toString(User user) {
		return "User: " + user + " [email: " + user.getEmail() + 
				" , dogs: [" + user.getDogs() + "]]";
	}
}
