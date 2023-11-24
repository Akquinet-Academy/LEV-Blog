package de.brightslearning.service;

import de.brightslearning.entity.Post;
import de.brightslearning.repository.PostRepository;

import java.util.List;
import java.util.Optional;

public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> findById(Integer postId) {
        return postRepository.findById(postId);
    }

    @Override
    public List<Post> findByOrderByDateDesc() {
        return postRepository.findByOrderByDateDesc();
    }
}
