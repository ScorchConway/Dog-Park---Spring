package com.example.dp.dogpark.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails {

	@Id
	@GeneratedValue
	private Integer id;
	
	@NotEmpty
	@Column //need not be unique
	private String username;
	
	@NotNull
	@Column(unique=true)
	private String email;
	
	@NotNull
	private String password;
	
	@OneToMany(mappedBy = "user")
	private List<Dog> dogs;
	
	@Column
	private ArrayList<Park> starredParks;
	
	@NotNull
	private boolean enabled = true;
	
	@NotNull
	private boolean credentialsExpired = false;
	
	@NotNull
	private boolean expired = false;
	
	@NotNull
	private boolean locked = false;
	
	//unidirectional relationship. app only needs to know what UserRole is assigned to a User.
	//Because UserRole doesn't need to have access to Users 
	//we don't need to update UserRole to model this relationship.
	@ManyToMany(
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL)
	@JoinTable
	Set<UserRole> userRoles;

	public User(String email, String username, String password) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.enabled = true;
		this.dogs = new ArrayList<Dog>();
		this.starredParks = new ArrayList<Park>();
		this.userRoles = new HashSet<UserRole>();
		this.userRoles.add(new UserRole("ROLE_USER", "user"));
	}
	
	public boolean isCredentialsExpired() {
		return credentialsExpired;
	}

	public void setCredentialsExpired(boolean credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	protected User() {}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", dogs=" + dogs + ", starredParks=" + starredParks + "]";
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Dog> getDogs() {
		return dogs;
	}
	
	public void addDog(Dog dog) {
		this.dogs.add(dog);
	}

	public void removeDog(Dog dog) {
		this.dogs.remove(dog);
	}
	
	public List<Park> getStarredParks() {
		return starredParks;
	}

	public void addStarredPark(Park park) {
		this.starredParks.add(park);
	}
	
	public void removeStarredPark(Park park) {
		this.starredParks.remove(park);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserRole> getUserRole() {
		return userRoles;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRoles = userRole;
	}

	
	//TODO: these methods populated when I added 'extends UserDetails'
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
