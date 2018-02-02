package com.example.dp.dogpark.web.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.dp.dogpark.validation.ValidEmail;

public class UserDto {

	@NotNull
	@Size(min = 1, message = "Size.userDto.username")
	private String username;
	
	@NotNull
	@ValidEmail
	private String email;
	
	//@ValidPassword
	//TODO: validate password
	private String password;
	
	@NotNull
	@Size(min = 1)
	private String matchingPassword;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}
}