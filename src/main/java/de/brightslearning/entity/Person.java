package de.brightslearning.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name = "benutzername")
    private String benutzername;

    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name = "passwort")
    private String passwort;

    @Column(name = "ist_admin")
    private boolean istAdmin;

    @Override
    public String toString() {
        return benutzername;
    }

    @OneToMany(mappedBy = "person", cascade = CascadeType.REFRESH)
    private List<Kommentar> kommentare;


    public void schreibeKommentar() {

    }
}
