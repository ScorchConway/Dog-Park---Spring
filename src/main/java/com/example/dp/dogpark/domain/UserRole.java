package com.example.dp.dogpark.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

//models a Spring Security Granted Authority
@Entity
public class UserRole {
	
	@Id
	@GeneratedValue
	private Long userRoleId;
	@NotNull
	private String code;
	@NotNull
	private String label;

	public UserRole() {
	}
	
	public UserRole(String code, String label) {
		this.code = code;
		this.label = label;
	}

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	
}
