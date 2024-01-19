package com.springboot.test.payload.request;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterRequest {
	
	@NotBlank
	@Email
	private String email;
	@NotBlank
	@Size(min = 8)
	private String password;
	// Set role as only "User"
//	public static final String[] SET_VALUE = new String[] {"User"};
	public Set<String> role;
	
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
	public Set<String> getRole() {
		return role;
	}
	public void setRole(Set<String> role) {
		this.role = role;
	}

}
