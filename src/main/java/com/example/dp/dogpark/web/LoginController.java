package com.example.dp.dogpark.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value="/login")
	public static String getLogin() {
		System.out.println("In LoginController > getLogin");
		return "login";
	}
}
