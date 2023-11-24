package de.brightslearning.controller;

import de.brightslearning.entity.Session;
import de.brightslearning.repository.SessionRepository;
import de.brightslearning.entity.User;
import de.brightslearning.repository.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Instant;
import java.util.Optional;
@Controller
public class LogInController {

private SessionRepository sessionRepository;
private UserRepository userRepository;

    public LogInController(SessionRepository sessionRepository, UserRepository userRepository) {
        this.sessionRepository = sessionRepository;
        this.userRepository = userRepository;
    }
//    public LogInController() {
//    }

    @PostMapping("/login")
    public String login(HttpServletResponse response) {
        Optional<User> optionalUser = userRepository.findByUsernameAndPassword("...", "...");
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

}