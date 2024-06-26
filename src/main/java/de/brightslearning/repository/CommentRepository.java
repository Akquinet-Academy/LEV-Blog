package de.brightslearning.repository;

import de.brightslearning.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByPostIdOrderByDateAsc(Integer postId);
}
