package com.smartfarmers.backend.services;

import com.smartfarmers.backend.entity.User;
	
public interface UserService {
	public User registerUser(User user);

    public User loginUser(String email, String password);

    public User getUserById(int id);
}
