package de.brightslearning.service;

import de.brightslearning.repository.SessionRepository;

public class SessionService {

    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }
}
