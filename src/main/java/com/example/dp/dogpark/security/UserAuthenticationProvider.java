package com.example.dp.dogpark.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

//Behind the curtain
//This class makes sure that a UserDetails fields: enabled, expired, credentialsExpired, locked, are in good standing.
//if any of those are bad, the class throws an authentication exception for us
// this class is autowired in WebSecurityConfig
@Component
public class UserAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
	private MyUserDetailsService userDetailsService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
												  UsernamePasswordAuthenticationToken authenticationToken) 
												  throws AuthenticationException {
		
		if(authenticationToken.getCredentials() == null || userDetails.getPassword() == null) {
			throw new BadCredentialsException("Credentials may not be null.");
		}
		
		if( ! passwordEncoder.matches((String) authenticationToken.getCredentials(), userDetails.getPassword())) {
			throw new BadCredentialsException("Invalid credentials.");
		}
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {

		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		
		return userDetails;
	}

}
