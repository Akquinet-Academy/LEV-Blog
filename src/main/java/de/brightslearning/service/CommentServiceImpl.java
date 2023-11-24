package de.brightslearning.service;

import de.brightslearning.entity.Comment;
import de.brightslearning.repository.CommentRepository;

import java.util.List;
import java.util.Optional;

public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> findById(Integer kommentarId) {
        return commentRepository.findById(kommentarId);
    }

    @Override
    public List<Comment> findByPostIdOrderByDate(Integer postId) {
        return findByPostIdOrderByDate(postId);
    }
}
