package com.example.dp.dogpark.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.dp.dogpark.domain.User;
import com.example.dp.dogpark.service.DogService;
import com.example.dp.dogpark.service.UserService;
import com.example.dp.dogpark.web.dto.UserDto;


@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private DogService dogService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public static String showRegistrationForm(Model model) {
	
		UserDto userDto = new UserDto();
		model.addAttribute("user", userDto);
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerNewUser(@RequestParam String email,
								  @RequestParam String username,
								  @RequestParam String password,
								  @RequestParam String matchingPassword,
								  Model model,
								  final RedirectAttributes redirectAttributes) {
		
		System.out.println("UserController > registerNewUser():");
		System.out.println("email: " + email + "\nusername: " + username);
		
		// TODO move validation and saving a new user to a different class
		// validate email is unique
		User duplicateUser = userService.findByEmail(email);
		if (duplicateUser != null) {
			//TODO add a message to errors "This email address has already been registered."
			//email and username should be in the text boxes
			System.out.println("FOUND duplicate email");
			return "/register";
		} else {
			System.out.println("NO duplicate email");
		}
		
		// validate passwords match
		if ( ! password.equals(matchingPassword)) {
			//TODO add a message to errors "passwords need to match."
			System.out.println("passwords do not match");
			return "/register";
		} else {
			System.out.println("passwords match");
		}
		
		String encryptedPassword = passwordEncoder.encode(password);
		User newUser = userService.createUser(email, username, encryptedPassword);
		model.addAttribute("user", newUser);
		System.out.println("newUser: " + newUser.toString());
		//TODO log user out if logged in (maybe request the user's browser delete the logged in cookie?)
		//TODO log user in
		
		redirectAttributes.addFlashAttribute("registerSuccess", "Registration Successful! You can now log in.");
		return "redirect:/login"; 
		//TODO add form to add dogs, and functionality to edit email and username
	}
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public String user() {
		
		return "userDetails";
	}
}










