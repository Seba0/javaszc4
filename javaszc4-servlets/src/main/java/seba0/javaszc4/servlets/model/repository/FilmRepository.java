package seba0.javaszc4.servlets.model.repository;

import seba0.javaszc4.servlets.model.entities.Film;

import java.util.Collection;
import java.util.Optional;

public interface FilmRepository {

    boolean insert(Film film);

    Optional<Film> getByTitle(String title);

    Collection<Film> getAll();

    boolean remove(Film film);
}
