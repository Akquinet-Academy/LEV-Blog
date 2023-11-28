package de.brightslearning.service;

import de.brightslearning.entity.Comment;
import de.brightslearning.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
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

    public void save(Comment comment) {
        commentRepository.save(comment);
    }
}
