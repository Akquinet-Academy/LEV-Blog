package de.brightslearning.repository;

import de.brightslearning.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByOrderByDateDesc();
}
