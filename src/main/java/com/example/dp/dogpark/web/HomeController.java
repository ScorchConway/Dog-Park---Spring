package com.example.dp.dogpark.web;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dp.dogpark.domain.Dog;
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
		
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = "";

		if(auth != null) {

			model.addAttribute("parks", parkService.findAll());
			model.addAttribute("numOfParks", parkService.count());
			
			UserDetails user = ((UserDetails)auth.getPrincipal());
			email = user.getUsername();
			
			model.addAttribute("dogs", dogService.findAll());
			
			
			model.addAttribute("email", email);
			System.out.println("user signed IN");
			System.out.println("auth.toString: " + auth.toString());
			System.out.println("email: " + email);

		} else {
			//else if not signed in
			System.out.println("user signed OUT");
		}
		
		return "home";		
	}
}
