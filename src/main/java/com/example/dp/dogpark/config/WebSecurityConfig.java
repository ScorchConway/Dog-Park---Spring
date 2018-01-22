package com.example.dp.dogpark.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.dp.dogpark.security.MyUserDetailsService;
import com.example.dp.dogpark.security.UserAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserAuthenticationProvider userAuthenticationProvider;
	
	@Autowired
	@Qualifier("userDetailsService")
	MyUserDetailsService userDetailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(userAuthenticationProvider);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
//			.anonymous().disable()  //this line causes infinite redirects to /login
			.authorizeRequests()
				.antMatchers("/register").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
			.and()
				.logout()  // logout is automatically applied by WebSecurityConfigurerAdapter. redirects to /login?logout
				.permitAll();
		//				.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"));

	}
	
	
	//this needs to be commented out for the custom UserDetailsService to work
	//https://docs.spring.io/spring-security/site/docs/5.0.0.BUILD-SNAPSHOT/reference/htmlsingle/#jc-authentication-userdetailsservice	
//	@Autowired
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//			.inMemoryAuthentication()
//				.withUser("user").password("password").roles("USER");
//	}
	
	
}
