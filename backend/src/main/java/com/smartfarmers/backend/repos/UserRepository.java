package com.smartfarmers.backend.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartfarmers.backend.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	// find user by email (for login)
    public User findByEmail(String email);
}
