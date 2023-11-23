package de.brightslearning.repository;

import de.brightslearning.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, String> {
    Optional<Session> findByIdAndExpiresAtAfter(String sessionId, Instant now);
}
