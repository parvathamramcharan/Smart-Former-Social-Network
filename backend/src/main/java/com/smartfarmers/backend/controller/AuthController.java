package com.smartfarmers.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartfarmers.backend.entity.User;
import com.smartfarmers.backend.services.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")  // Allow React requests
public class AuthController {
		@Autowired
	    private UserService userService;

	    // REGISTER	
	    @PostMapping("/register")
	    public User registerUser(@RequestBody User user) {
	        return userService.registerUser(user);
	    }
	    
	    // LOGIN
	    @PostMapping("/login")
	    public User login(@RequestBody User loginRequest) {
	        return userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
	    }
}
