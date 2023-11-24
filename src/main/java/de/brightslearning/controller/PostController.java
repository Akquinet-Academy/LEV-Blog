package de.brightslearning.controller;

import de.brightslearning.entity.Post;
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
@RequestMapping(value = "/post")
public class PostController {

   private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "/allposts")
    public String allPosts(Model model) {
        List<Post> postList = postService.findAll();

        model.addAttribute("postList", postList);

        return "/allposts";
    }
    @PostMapping(value = "/allposts")
    public String store(@Valid @ModelAttribute("posts") Post post, BindingResult result) {
        if (result.hasErrors()) {
            return "/allposts";
        }

        postService.save(post);

        return "redirect:/allposts/post";
    }

    @PostMapping(value = "/delete")
    public String delete(@ModelAttribute(name = "post") Post post) {
        postService.deleteById(post.getId());

        return "redirect:/post";
    }
}
