package com.example.dp.dogpark.web;


import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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
		
		int numOfParks = parkService.count();
		model.addAttribute("numOfParks", numOfParks);
		
		ArrayList<Park> parks = (ArrayList<Park>) parkService.findAll();
		model.addAttribute("parks", parks);
		
		
		
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = "";
		//TODO: if signed in
		if(auth != null) {
			Object user = auth.getPrincipal();
			
			if(user instanceof UserDetails) {
				email = ((UserDetails)user).getUsername();
			} else {
				email = user.toString();
			}
			
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
	
	@RequestMapping(value="/update")
	public static String updateUser() {
		System.out.println("In HomeController > updateFoo");
		return "updateUserProfile";
	}
	
	
}
