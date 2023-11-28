package de.brightslearning.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "session")
public class Session {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();
    @ManyToOne
    @JoinColumn(name="users_id")
    private User user;
    @Column(name = "expires_at")
    private Instant expiresAt;

    public Session() {
    }

    public Session(User user, Instant instant) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Instant getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Instant expiresAt) {
        this.expiresAt = expiresAt;
    }
}
