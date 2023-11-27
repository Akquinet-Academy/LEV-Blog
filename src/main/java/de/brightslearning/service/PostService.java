package de.brightslearning.service;

import de.brightslearning.entity.Post;
import de.brightslearning.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PostService{

    private final PostRepository postRepository;
    @Autowired
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

    public void save(Post post) {
        postRepository.save(post);
    }

    public void deleteById(int id) {
        postRepository.deleteById(id);
    }
}

