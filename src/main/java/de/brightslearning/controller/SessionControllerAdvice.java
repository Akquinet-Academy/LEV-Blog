package de.brightslearning.controller;

import de.brightslearning.entity.Session;
import de.brightslearning.repository.SessionRepository;
import de.brightslearning.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.Instant;
import java.util.Optional;

@ControllerAdvice
public class SessionControllerAdvice {

    private final SessionRepository sessionRepository;

    @Autowired
    public SessionControllerAdvice(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @ModelAttribute("sessionUser")
    public User sessionUser(@CookieValue(value = "sessionId", defaultValue = "") String sessionId, Model model) {
            if(!sessionId.isEmpty()) {
                Optional<Session> optionalSession = sessionRepository.findByIdAndExpiresAtAfter(
                        sessionId, Instant.now());
                if (optionalSession.isPresent()) {
                    Session session = optionalSession.get();

                    // neues Ablaufdatum für die Session
                    session.setExpiresAt(Instant.now().plusSeconds(7*24*60*60));
                    model.addAttribute("username", session.getUser().getUsername());


                    return session.getUser();
                    // User ist eingeloggt....
                }
            }
            return null;
    }
}
