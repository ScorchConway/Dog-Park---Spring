package com.example.dp.dogpark.web;


import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

import com.example.dp.dogpark.domain.Park;
import com.example.dp.dogpark.service.DogService;
import com.example.dp.dogpark.service.ParkService;
import com.example.dp.dogpark.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	@Autowired
	private DogService dogService;
	@Autowired
	private static ParkService parkService;
	
	
	@RequestMapping(value="/")
	public static String getHomePage(HttpServletRequest request, Model model) {
		System.out.println("In HomeController > getHomePage");
		
		
		//add parks to model
		//causing a null pointer exception
//		Iterable<Park> parks = parkService.findAll(); 
//		model.addAttribute("parks", parks);

		Principal user = request.getUserPrincipal();
		System.out.println("user: " + user);

		//if signed in
		if(user != null) {
			//add user to model (includes user's dogs right?)
			//I think we can get user.dogs, user.starredParks, etc from this attribute
			//to hide implementation details from HTML, add user attributes to the model separately
			model.addAttribute("user", user);
			System.out.println("user signed IN");
		} else {
			//else if not signed in
			System.out.println("user signed OUT");
		}
		
		return "home";		
	}
	
	@RequestMapping(value="/update")
	public static String updateUser() {
		System.out.println("In HomeController > updateFoo");
		return "updateUserProfile";
	}
}
