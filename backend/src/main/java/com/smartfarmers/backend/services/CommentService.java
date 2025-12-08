package com.smartfarmers.backend.services;

import java.util.List;

import com.smartfarmers.backend.entity.Comment;

public interface CommentService {
	public Comment addComment(int postId, int userId, Comment comment);

    public List<Comment> getCommentsByPost(int postId);
    
}
