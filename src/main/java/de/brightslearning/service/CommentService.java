package de.brightslearning.service;

import de.brightslearning.entity.Comment;
import de.brightslearning.repository.CommentRepository;

import java.util.List;
import java.util.Optional;

public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public Optional<Comment> findById(Integer kommentarId) {
        return commentRepository.findById(kommentarId);
    }

    public List<Comment> findByPostIdOrderByDateAsc(Integer postId) {
        return commentRepository.findByPostIdOrderByDateAsc(postId);
    }
}
