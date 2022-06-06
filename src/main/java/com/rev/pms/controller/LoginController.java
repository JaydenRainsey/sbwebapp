package com.rev.pms.controller;

import com.rev.pms.model.LoginTemplate;
import com.rev.pms.model.User;

import com.rev.pms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@Autowired
	private User user;


	@Autowired
	private UserService userService;
	
	
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody LoginTemplate loginTemplate) {
		return ResponseEntity.ok(userService.login(loginTemplate.getUsername(), loginTemplate.getPassword()));
	}
	
	@PostMapping("/logout")
	public ResponseEntity<Void> logout() {
		userService.logout();
		
		return ResponseEntity.accepted().build();
	}
}
