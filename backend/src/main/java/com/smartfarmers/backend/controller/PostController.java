package com.smartfarmers.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartfarmers.backend.entity.Post;
import com.smartfarmers.backend.services.PostService;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "*")
public class PostController {
	    @Autowired
	    private PostService postService;

	    // CREATE POST → /api/posts/user/5/create
	    @PostMapping("/user/{userId}/create")
	    public Post createPost(@PathVariable int userId, @RequestBody Post post) {
	        return postService.createPost(userId, post);
	    }

	    // GET ALL POSTS → /api/posts
	    @GetMapping
	    public List<Post> getAllPosts() {
	        return postService.getAllPosts();
	    }

	    // GET POST BY ID → /api/posts/10
	    @GetMapping("/{postId}")
	    public Post getPostById(@PathVariable int postId) {
	        return postService.getPostById(postId);
	    }

	    // FILTER BY CATEGORY → /api/posts/filter?category=paddy
	    @GetMapping("/filter")
	    public List<Post> getByCategory(@RequestParam String category) {
	        return postService.getPostsByCategory(category);
	    }

	    // GET POSTS BY USER → /api/posts/user/5
	    @GetMapping("/user/{userId}")
	    public List<Post> getPostsByUser(@PathVariable int userId) {
	        return postService.getPostsByUser(userId);
	    }

}
