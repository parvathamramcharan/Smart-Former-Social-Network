package com.smartfarmers.backend.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartfarmers.backend.entity.Post;
import com.smartfarmers.backend.entity.User;
import com.smartfarmers.backend.repos.PostRepository;
import com.smartfarmers.backend.repos.UserRepository;
import com.smartfarmers.backend.services.PostService;

@Service
public class PostServiceImpl  implements PostService {
	 @Autowired
	    private PostRepository postRepository;

	    @Autowired
	    private UserRepository userRepository;

	    @Override
	    public Post createPost(int userId, Post post) {
	        User user = userRepository.findById(userId)
	                .orElseThrow(() -> new RuntimeException("User not found"));

	        post.setUser(user);
	        return postRepository.save(post);
	    }

	    @Override
	    public List<Post> getAllPosts() {
	        return postRepository.findAll();
	    }

	    @Override
	    public Post getPostById(int postId) {
	        return postRepository.findById(postId)
	                .orElseThrow(() -> new RuntimeException("Post not found"));
	    }

	    @Override
	    public List<Post> getPostsByCategory(String category) {
	        return postRepository.findByCategory(category);
	    }

	    @Override
	    public List<Post> getPostsByUser(int userId) {
	        return postRepository.findByUserUserId(userId);
	    }
}
