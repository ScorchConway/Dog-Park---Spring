package com.example.dp.dogpark.service;

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
import com.example.dp.dogpark.repository.UserRepository;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
		
		com.example.dp.dogpark.domain.User dogparkUser = userRepository.findByEmail(email);
		List<GrantedAuthority> authorities = buildUserAuthority(dogparkUser.getUserRole());
		return buildUserForAuthentication(dogparkUser, authorities);
	}

	// Converts user to spring.springframework.security.core.userdetails.User
    private User buildUserForAuthentication(com.example.dp.dogpark.domain.User user, List<GrantedAuthority> authorities) {
    	return new User(user.getEmail(), user.getPassword(),
            user.isEnabled(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
        // add user's authorities
        for (UserRole userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getCode()));
        }
        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
        return Result;
    }

}

