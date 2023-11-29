package de.brightslearning.controller;

import de.brightslearning.entity.User;
import de.brightslearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public String makeAdmin(@PathVariable int userId) {
        System.out.println("reached method");
        Optional<User> optionalUser = userService.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setAdmin(true);
            userService.save(user);
        }
        return "redirect:/users";
    }
}
