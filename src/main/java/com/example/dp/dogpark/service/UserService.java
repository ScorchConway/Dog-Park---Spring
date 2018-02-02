package com.example.dp.dogpark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dp.dogpark.domain.Dog;
import com.example.dp.dogpark.domain.Park;
import com.example.dp.dogpark.domain.User;
import com.example.dp.dogpark.repository.DogRepository;
import com.example.dp.dogpark.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private DogRepository dogRepository;

	@Autowired
	public UserService(UserRepository userRepository, DogRepository dogRepository) {
		this.userRepository = userRepository;
		this.dogRepository = dogRepository;
	}
	
	/**
	 * 
	 * @param email
	 * @param username
	 * @param password
	 */
	public User createUser(String email, String username, String password) {
		return userRepository.save(new User(email, username, password));
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public void addDogToUser(Dog dog, User user) {
		user.addDog(dog);
	}
	
	public void removeDogFromUser(Dog dog, User user) {
		user.removeDog(dog);
		dogRepository.delete(dog);
	}
	
	public List<Dog> getDogs(User user) {
		return user.getDogs();
	}
	
	public long total() {
		return userRepository.count();
	}
	
	public String toString(User user) {
		return "User: " + user + " [email: " + user.getEmail() + 
				" , dogs: [" + user.getDogs() + "]]";
	}
	
	public void addStarredPark(Park park, User user) {
		user.addStarredPark(park);
	}
	
	public void removeStarredPark(Park park, User user) {
		user.removeStarredPark(park);
	}
}
