package de.brightslearning.controller;

import de.brightslearning.entity.Comment;
import de.brightslearning.entity.Post;
import de.brightslearning.service.CommentService;
import de.brightslearning.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping(value = "/post")

public class PostController {

   private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "/")
    public String allPosts(Model model) {
//        List<Post> postList = postService.findByOrderByDateDesc();
        List<Post> postList = postService.findAll();
        model.addAttribute("postList", postList);
        return "index";
    }

    @GetMapping(value = "/newpost")
    public String newPost(Model model) {
        Post post = new Post();
        model.addAttribute("post", post);
        return "newpost";
    }

    @PostMapping(value = "/newpost")
    public String store(@ModelAttribute("post") Post post) {
        postService.save(post);
        return "redirect:/";
    }

    @PostMapping(value = "/delete")
    public String delete(@ModelAttribute(name = "post") Post post) {
        postService.deleteById(post.getId());
//        return "redirect:/";
        return "index";
    }

    @GetMapping("/post/{id}")
    public String showPostDetails(@PathVariable int id, Model model) {
        Optional<Post> optionalPost = postService.findById(id);
        if (optionalPost.isPresent()) {
            Post thisPost = postService.findById(id).orElseThrow();
            List<Comment> commentList = thisPost.getComments();
            model.addAttribute("thisPost", thisPost);
            model.addAttribute("commentList", commentList);
            model.addAttribute("newComment", new Comment());
            return "post";
        }
        return "index";
    }
}
