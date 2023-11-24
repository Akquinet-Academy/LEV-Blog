package de.brightslearning.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date", columnDefinition = "DATE")
    private LocalDate date;

    @Column(name = "text")
    private String text;

    @OneToMany(mappedBy = "post", cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "comment_id")
    private List<Comment> comments;


    public int getId() {
        return this.id;
    }
}
