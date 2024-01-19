package com.springboot.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.test.model.User;
import com.springboot.test.payload.request.LoginRequest;
import com.springboot.test.payload.request.RegisterRequest;
import com.springboot.test.payload.response.JwtResponse;
import com.springboot.test.payload.response.MessageResponse;
import com.springboot.test.security.jwt.JwtUtils;
import com.springboot.test.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	UserService userService;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		JwtResponse jwtResponse = userService.authenticateUser(loginRequest);

		return ResponseEntity.ok(jwtResponse);
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
		if (userService.existsByUsername(registerRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already taken!"));
		}
		User user = userService.registerUser(registerRequest);
		userService.saveUser(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}