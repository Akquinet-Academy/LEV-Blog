package de.brightslearning.controller;

import de.brightslearning.entity.Post;
import de.brightslearning.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
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

    @PostMapping(value = "/newpost")
    public String store(@Valid @ModelAttribute("posts") Post post, BindingResult result) {
        if (result.hasErrors()) {
            return "index";
        }
        postService.save(post);
//        return "redirect:/";
        return "index";
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
            model.addAttribute("thisPost", thisPost);
            return "post";
        }
        return "index";
    }
}
