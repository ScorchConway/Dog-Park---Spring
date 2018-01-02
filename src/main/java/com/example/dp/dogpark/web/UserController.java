package com.example.dp.dogpark.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dp.dogpark.service.DogService;
import com.example.dp.dogpark.service.UserService;

@Controller
@RequestMapping(value="users")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private DogService dogService;
	
	@RequestMapping(method = RequestMethod.GET)
	public static String displayUser() {
	
		return "updateUserProfile";
	}
	
}
