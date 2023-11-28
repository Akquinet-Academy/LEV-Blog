package de.brightslearning.controller;

import de.brightslearning.entity.User;
import de.brightslearning.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value="/users")
    public String showUsers(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("userList", userList);
        return "users";
    }

    @PostMapping(value = "/users/makeAdmin/{userId}")
    public String makeAdmin(@PathVariable(name = "userId") Integer userId) {
        System.out.println("reached method");
        User siteUser = userService.findById(userId).orElseThrow();
        siteUser.setAdmin(true);
        return "redirect:/users";
    }
}
