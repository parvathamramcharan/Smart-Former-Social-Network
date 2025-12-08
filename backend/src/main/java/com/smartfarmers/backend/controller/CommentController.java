package com.smartfarmers.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartfarmers.backend.entity.Comment;
import com.smartfarmers.backend.services.CommentService;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = "*")
public class CommentController {
	    @Autowired
	    private CommentService commentService;

	    // ADD COMMENT → POST /api/comments/post/10/user/3
	    @PostMapping("/post/{postId}/user/{userId}")
	    public Comment addComment(
	            @PathVariable int postId,
	            @PathVariable int userId,
	            @RequestBody Comment comment) {

	        return commentService.addComment(postId, userId, comment);
	    }

	    // GET COMMENTS OF POST → GET /api/comments/post/10
	    @GetMapping("/post/{postId}")
	    public List<Comment> getCommentsByPost(@PathVariable int postId) {
	        return commentService.getCommentsByPost(postId);
	    }
}
