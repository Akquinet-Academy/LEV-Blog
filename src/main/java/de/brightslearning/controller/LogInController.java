package de.brightslearning.controller;

import de.brightslearning.entity.Post;
import de.brightslearning.entity.Session;
import de.brightslearning.repository.SessionRepository;
import de.brightslearning.entity.User;
import de.brightslearning.repository.UserRepository;
import de.brightslearning.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.util.Optional;
@Controller
//@RequestMapping(value = "/login")
public class LogInController {

private final SessionRepository sessionRepository;
private final UserRepository userRepository;

    public LogInController(SessionRepository sessionRepository, UserRepository userRepository) {
        this.sessionRepository = sessionRepository;
        this.userRepository = userRepository;
    }

//    public LogInController() {
//    }
    @PostMapping("/login")
    public String login(@ModelAttribute(name = "username") String username, @ModelAttribute(name = "password") String password, HttpServletResponse response) {
        Optional<User> optionalUser = userRepository.findByUsernameAndPassword(username, password);
        if (optionalUser.isPresent()) {
            Session session = new Session(optionalUser.get(), Instant.now().plusSeconds(7*24*60*60));
            sessionRepository.save(session);
            Cookie cookie = new Cookie("sessionId", session.getId());
            response.addCookie(cookie);
            // Login erfolgreich
            return "redirect:/";
        }
        // Login nicht erfolgreich
        return "login";
    }

    @GetMapping("/signup")
    public String newUser(Model model) {
        User newUser = new User();
        model.addAttribute("user", newUser);
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute(name = "user") User user) {
        userRepository.save(user);
        return "redirect:/";
    }

}
