package com.smartfarmers.backend.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartfarmers.backend.entity.User;
import com.smartfarmers.backend.repos.UserRepository;
import com.smartfarmers.backend.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	 @Autowired
	    private UserRepository userRepository;

	    @Override
	    public User registerUser(User user) {
	        if (userRepository.findByEmail(user.getEmail()) != null) {
	            throw new RuntimeException("Email already registered");
	        }
	        return userRepository.save(user);
	    }
	    
	    @Override
	    public User loginUser(String email, String password) {
	        User user = userRepository.findByEmail(email);

	        if (user == null)
	            throw new RuntimeException("User not found");

	        if (!user.getPassword().equals(password))
	            throw new RuntimeException("Incorrect password");

	        return user;
	    }

	    @Override
	    public User getUserById(int id) {
	        return userRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("User not found"));
	    }
}
