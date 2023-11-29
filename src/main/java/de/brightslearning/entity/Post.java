package de.brightslearning.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "image")
    private String image;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

    @Column(name = "date", columnDefinition = "DATE")
    private LocalDateTime date;

    @Column(name = "text")
    private String text;

    @OneToMany(mappedBy = "post", cascade = {CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.EAGER)
//    @JoinColumn(name = "comment_id")
    private List<Comment> comments;

    public Post() {
    }

    public Post(String title, User user, LocalDateTime date, String text) {
        this.title = title;
        this.user = user;
        this.date = date;
        this.text = text;

    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
