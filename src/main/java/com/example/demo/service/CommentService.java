package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Comment;
import com.example.demo.model.Item;
import com.example.demo.repository.CommentRepository;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getCommentsByItem(Item item) {
        return commentRepository.findByItem(item);
    }

    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }
}

