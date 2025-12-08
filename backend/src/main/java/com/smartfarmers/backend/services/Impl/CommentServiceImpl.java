package com.smartfarmers.backend.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartfarmers.backend.entity.Comment;
import com.smartfarmers.backend.entity.Post;
import com.smartfarmers.backend.entity.User;
import com.smartfarmers.backend.repos.CommentRepository;
import com.smartfarmers.backend.repos.PostRepository;
import com.smartfarmers.backend.repos.UserRepository;
import com.smartfarmers.backend.services.CommentService;

@Service
public class CommentServiceImpl  implements CommentService {
	@Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Comment addComment(int postId, int userId, Comment comment) {

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        comment.setPost(post);
        comment.setUser(user);

        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getCommentsByPost(int postId) {
        return commentRepository.findByPostPostId(postId);
    }
}
