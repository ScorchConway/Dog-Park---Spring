package com.example.dp.dogpark.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dp.dogpark.domain.User;
import com.example.dp.dogpark.service.DogService;
import com.example.dp.dogpark.service.UserService;
import com.example.dp.dogpark.web.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;


@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private DogService dogService;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public static String showRegistrationForm(Model model) {
	
		UserDto userDto = new UserDto();
		model.addAttribute("user", userDto);
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerNewUser(@ModelAttribute String email,
								  @ModelAttribute String username,
								  @ModelAttribute String password,
								  @ModelAttribute String matchingPassword,
								  Model model) {
		
		System.out.println("UserController > registerNewUser():");
		System.out.println("email: " + email + "\nusername: " + username);
		
		//validate email is unique
		User duplicateUser = userService.findByEmail(email);
		if (duplicateUser != null) {
			//TODO add a message to errors "This email address has already been registered."
			//email and username should be in the fields
			return "/register";
		}
		if ( ! password.equals(matchingPassword)) {
			//TODO add a message to errors "passwords need to match."
			return "/register";
		}
		
		
		//validate passwords match
		User newUser = userService.createUser(email, username, password);
		
		model.addAttribute("user", newUser);
		return "/userDetails"; //TODO add form to add dogs, and functionality to edit email and username
	}
}










