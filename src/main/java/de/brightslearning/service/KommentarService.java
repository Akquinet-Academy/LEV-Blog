package de.brightslearning.service;

import de.brightslearning.entity.Kommentar;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface KommentarService {
    List<Kommentar> findAll();

    Optional<Kommentar> findById(Integer kommentarId);


}
