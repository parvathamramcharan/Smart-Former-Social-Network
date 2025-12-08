package com.smartfarmers.backend.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartfarmers.backend.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer>{
	 // get comments for a post
    public List<Comment> findByPostPostId(Integer postId);
}
