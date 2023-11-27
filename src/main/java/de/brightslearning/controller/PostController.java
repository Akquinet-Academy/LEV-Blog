package de.brightslearning.controller;

import de.brightslearning.entity.Post;
import de.brightslearning.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
//@RequestMapping(value = "/post")
public class PostController {

   private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "/")
    public String allPosts(Model model) {
        List<Post> postList = postService.findAll();
        model.addAttribute("postList", postList);
        return "index";
    }
    @GetMapping(value = "/newpost")
    public String newPost(Model model) {
        Post post = new Post();
        model.addAttribute("post", post);
//        List<Post> postList = postService.findAll();
//        model.addAttribute("postList", postList);
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
}
