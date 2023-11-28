package de.brightslearning.controller;

import de.brightslearning.entity.Post;
import de.brightslearning.entity.Session;
import de.brightslearning.repository.SessionRepository;
import de.brightslearning.entity.User;
import de.brightslearning.repository.UserRepository;
import de.brightslearning.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Optional;

@Controller
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
    public String login(@ModelAttribute(name = "user") User user, HttpServletResponse response) {
        Optional<User> optionalUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
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
    @PostMapping("/logout")
    public String logout(@CookieValue(value = "sessionId", defaultValue = "") String sessionId, HttpServletResponse response) {
        sessionRepository.deleteById(sessionId);
        Cookie cookie = new Cookie("sessionId", null);
        response.addCookie(cookie);
        return "redirect:/";
    }

    @GetMapping(value = "/login")
    public String getLoginTemplate(Model model){
        model.addAttribute("user",new User());
        return "login";
    }

    @GetMapping(value="/about")
    public String getAboutUs(){
        return "about";
    }

    @GetMapping("/signup")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String store(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "redirect:/";
    }

}
