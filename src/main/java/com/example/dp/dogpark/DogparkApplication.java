package com.example.dp.dogpark;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.example.dp.dogpark.domain.Dog;
import com.example.dp.dogpark.domain.DogSize;
import com.example.dp.dogpark.domain.User;
import com.example.dp.dogpark.service.DogService;
import com.example.dp.dogpark.service.UserService;



@EnableWebSecurity
@SpringBootApplication
public class DogparkApplication implements CommandLineRunner {

	@Autowired
	private DogService dogService;
	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(DogparkApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		
		User user = userService.createUser("example@email.com", new ArrayList<Dog>());
		Dog dog = dogService.createDog("Atticus", "Golden Retreiver", DogSize.Large, new String[]{"playful", "ball hog", "likes people"});
		user.addDog(dog);
		
		dog = dogService.createDog("Ripley", "Lab mix", DogSize.Medium, new String[]{"ball hog", "high energy", "likes people"});
		user.addDog(dog);
		
		System.out.println("dog: " + dog.toString());
		System.out.println("user: " + user.toString());
		
		
		
		
		//Create some dogs
//		dogService.createDog("Ripley", "Lab mix", DogSize.Large, new String[]{"energetic", "ballhog", "sweet"});
//		dogService.createDog("McArtney", "Irish Setter", DogSize.Large, new String[]{"yippy", "lanky", "fast"});
//		dogService.createDog("Lenny", "Beagle", DogSize.Medium, new String[]{"playful", "independent", "likes people"});
//		dogService.createDog("Abbey", "Shepherd", DogSize.Large, new String[]{"dog mom", "sweet"});
//		dogService.createDog("Perito", "Chihuahua mix", DogSize.Small, new String[]{"fly face", "sweet", "gross"});
//		System.out.println("Number of Users: " + userService.total());
//		System.out.println("Number of dogs: " + dogService.total());
//		System.out.println("user: " + user.toString());
		
		
		
	}
}
