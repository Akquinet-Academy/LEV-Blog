package de.brightslearning.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Entity
@Table(name = "beitrag")
public class Beitrag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "titel")
    private String titel;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "datum", columnDefinition = "DATE")
    private LocalDate datum;

    @Column(name = "text")
    private String text;

    @OneToMany(mappedBy = "beitrag", cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "kommentar_id")
    private List<Kommentar> kommentare;




}
