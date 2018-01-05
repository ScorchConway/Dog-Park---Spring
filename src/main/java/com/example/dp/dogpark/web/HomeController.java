package com.example.dp.dogpark.web;


import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

import com.example.dp.dogpark.domain.Park;
import com.example.dp.dogpark.repository.ParkRepository;
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
	private ParkService parkService;
	@Autowired
	private ParkRepository parkRepository;
	
	@RequestMapping(value="/")
	public String getHomePage(HttpServletRequest request, Model model) {
		System.out.println("In HomeController > getHomePage");
		
		int numOfParks = parkService.count();
		model.addAttribute("numOfParks", numOfParks);
		
		ArrayList<Park> parks = (ArrayList<Park>) parkService.findAll();
		model.addAttribute("parks", parks);
		
		//I'm curious what this returns
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("user", auth);
		System.out.println("auth: " + auth);

		//if signed in
		if(auth != null) {
			//add auth to model (includes user's dogs right?)
			//I think we can get user.dogs, user.starredParks, etc from this attribute
			//to hide implementation details from HTML, add user attributes to the model separately
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
