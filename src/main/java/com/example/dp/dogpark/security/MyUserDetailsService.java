package com.example.dp.dogpark.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dp.dogpark.domain.UserRole;
import com.example.dp.dogpark.service.UserService;


// This class has one public method loadUserByUsername
// that accepts a String email and returns a userdetails object for that user if they exist

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	/**
	 * Locates the user based on the email
	 * @param email the email identifying the user whose data is required.
	 * @returns a fully populated user record
	 */
	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
//		System.out.println("MyUserDetailsService > loadUserByUsername() email:" + email);
		com.example.dp.dogpark.domain.User dogparkUser = userService.findByEmail(email); 

//		System.out.println("MyUserDetailsService > loadUserByUsername() dogparkUser.toString(): " + dogparkUser.toString());
		List<GrantedAuthority> authorities = buildUserAuthority(dogparkUser.getUserRole());
		return buildUserForAuthentication(dogparkUser, authorities);
	}

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
        Set<GrantedAuthority> setGrantedAuths = new HashSet<GrantedAuthority>();
        // add user's authorities
        for (UserRole userRole : userRoles) {
            setGrantedAuths.add(new SimpleGrantedAuthority(userRole.getCode()));
        }
        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setGrantedAuths);
        return Result;
    }

    // Converts user to a spring security userdetails object
    private User buildUserForAuthentication(com.example.dp.dogpark.domain.User user, List<GrantedAuthority> authorities) {
    	User userdetails = new User(user.getEmail(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
    	System.out.println("MyUserDetailsService returned userDetails: " + userdetails.toString());
    	return userdetails;
    }
}

