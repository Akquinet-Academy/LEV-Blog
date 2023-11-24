package de.brightslearning.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "kommentar")
public class Kommentar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "text")
    private String text;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "datum", columnDefinition = "DATE")
    private LocalDate datum;
    @ManyToOne (cascade = CascadeType.REFRESH)
    @JoinColumn(name = "person_id")
    private Person person;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "beitrag_id")
    private Beitrag beitrag;
}
