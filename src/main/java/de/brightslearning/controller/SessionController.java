package de.brightslearning.controller;

import de.brightslearning.repository.SessionRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SessionController {

   /* private final SessionRepository sessionRepository;

    public SessionController(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @GetMapping("/")
    public String home(HttpServletResponse response, Model model)
    {
        final String food = "Pizza";
        Cookie newCookie = new Cookie("food", food);
        response.addCookie(newCookie);
        return "home";
    }*/
}
