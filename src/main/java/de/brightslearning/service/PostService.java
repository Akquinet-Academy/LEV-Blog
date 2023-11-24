package de.brightslearning.service;

import de.brightslearning.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> findAll();

    Optional<Post> findById(Integer postId);

    List<Post> findByOrderByDateDesc();
}
