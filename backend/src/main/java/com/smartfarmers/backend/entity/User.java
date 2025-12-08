package com.smartfarmers.backend.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity 
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "user_id") 
	private int userId; 
	
	@Column(name = "name", nullable = false, length = 100) 
	private String name;
	
	@Column(name = "email", nullable = false, unique = true, length = 100) 
	private String email;
	
	@Column(name = "password", nullable = false, length = 100)
	private String password; 
	
	@Column(name = "role", length = 20) 
	private String role = "FARMER"; 
	
	@Column(name = "joined_on")
	private LocalDateTime joinedOn = LocalDateTime.now(); 
	
	@JsonIgnore @OneToMany(mappedBy = "user") 
	private List<Post> posts;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Comment> comments;
}
