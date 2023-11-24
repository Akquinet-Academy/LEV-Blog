package de.brightslearning.service;

import de.brightslearning.entity.Comment;

import java.util.List;
import java.util.Optional;

public interface KommentarService {
    List<Comment> findAll();

    Optional<Comment> findById(Integer kommentarId);


}
