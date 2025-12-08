package com.smartfarmers.backend.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartfarmers.backend.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
	 // filter by category
    public List<Post> findByCategory(String category);

    // get all posts of a user (for Profile page)
     public  List<Post> findByUserUserId(Integer userId);
}
