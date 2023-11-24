package de.brightslearning.service;

import de.brightslearning.entity.Post;
import de.brightslearning.repository.PostRepository;

import java.util.List;
import java.util.Optional;

public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Optional<Post> findById(Integer postId) {
        return postRepository.findById(postId);
    }

    public List<Post> findByOrderByDateDesc() {
        return postRepository.findByOrderByDateDesc();
    }
}
