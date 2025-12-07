package com.smartfarmers.backend.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int commentId;

    //many comments to one post
    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    //many comments to one user
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "message", columnDefinition = "TEXT", nullable = false)
    private String message;

    @Column(name = "is_solution")
    private boolean isSolution = false;

    @Column(name = "commented_on")
    private LocalDateTime commentedOn = LocalDateTime.now();
}
