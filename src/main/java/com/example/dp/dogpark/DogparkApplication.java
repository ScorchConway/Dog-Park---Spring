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
import com.example.dp.dogpark.domain.Park;
import com.example.dp.dogpark.domain.ParkAddress;
import com.example.dp.dogpark.domain.User;
import com.example.dp.dogpark.service.DogService;
import com.example.dp.dogpark.service.ParkService;
import com.example.dp.dogpark.service.UserService;



@EnableWebSecurity
@SpringBootApplication
public class DogparkApplication implements CommandLineRunner {

	@Autowired
	private DogService dogService;
	@Autowired
	private UserService userService;
	@Autowired 
	ParkService parkService;
	
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
		
		Park park = parkService.createPark("Shawnee Mission Off Leash Area", new ParkAddress("7900 Renner Rd", "", "Shawnee", "KS", 66219)
				, "http://www.jcprd.com/parks_facilities/shawnee_mission.cfm"
				, "https://www.google.com/maps/place/Shawnee+Mission+Park+Dog+Off-Leash+Area/@38.9796246,-94.8034713,15z/data=!4m5!3m4!1s0x0:0xaaef772be468f025!8m2!3d38.9796246!4d-94.8034713");
		
		parkService.createPark("Leawoof Dog Park", new ParkAddress("106th & Lee Boulevard", "", "Leawood", "KS", 66211)
				, "https://www.leawood.org/parks/dogpark.aspx"
				, "https://www.google.com/maps/place/Leawoof+Dog+Park/@39.0474457,-94.7417861,11z/data=!4m8!1m2!2m1!1sleawood+dog+park!3m4!1s0x87c0e9a5cb8450ff:0xc46287c51515b4a7!8m2!3d38.9332894!4d-94.6116024");
		
		System.out.println("park: " + park.toString());
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
