package com.example.dp.dogpark;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.dp.dogpark.domain.DogSize;
import com.example.dp.dogpark.service.DogService;


@SpringBootApplication
public class DogparkApplication implements CommandLineRunner {

	@Autowired
	private DogService dogService;
	
	public static void main(String[] args) {
		SpringApplication.run(DogparkApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		//Create some dogs
		dogService.createDog("Atticus", "Golden Retreiver", DogSize.Large, new String[]{"playful", "ballhog", "sweet"});
		dogService.createDog("Ripley", "Lab mix", DogSize.Large, new String[]{"energetic", "ballhog", "sweet"});
		dogService.createDog("McArtney", "Irish Setter", DogSize.Large, new String[]{"yippy", "lanky", "fast"});
		dogService.createDog("Lenny", "Beagle", DogSize.Medium, new String[]{"playful", "ballhog", "sweet"});
		dogService.createDog("Abbey", "Shepherd", DogSize.Large, new String[]{"dog mom", "sweet"});
		dogService.createDog("Perito", "Chihuahua mix", DogSize.Small, new String[]{"fly face", "sweet", "gross"});
		System.out.println("Number of dogs: " + dogService.total());
		
		
	}
}
