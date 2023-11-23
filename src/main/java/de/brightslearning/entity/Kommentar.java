package de.brightslearning.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Kommentar {

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
