package de.brightslearning.controller;

import de.brightslearning.entity.Comment;
import de.brightslearning.entity.Post;
import de.brightslearning.entity.User;
import de.brightslearning.repository.PostRepository;
import de.brightslearning.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class CommentController {

    private final CommentService commentService;
    private final PostRepository postRepository;

    public CommentController(CommentService commentService, PostRepository postRepository) {
        this.commentService = commentService;
        this.postRepository = postRepository;
    }

    @PostMapping("/post/{postid}/comment")
    public String store(@PathVariable int postid, @ModelAttribute("newComment") Comment comment, @ModelAttribute("sessionUser") User sessionUser) {
        Optional<Post> post = postRepository.findById(postid);
        if (post.isPresent()) {
            comment.setPost(post.get());
            comment.setDate(LocalDateTime.now());
            comment.setUser(sessionUser);
            commentService.save(comment);
        }
        return "redirect:/post/" + postid;
    }
}
