package com.smartfarmers.backend.services;

import java.util.List;

import com.smartfarmers.backend.entity.Post;

public interface PostService {
	    public Post createPost(int userId, Post post);

	    public List<Post> getAllPosts();

	    public Post getPostById(int postId);

	    public List<Post> getPostsByCategory(String category);

	    public List<Post> getPostsByUser(int userId);
}
