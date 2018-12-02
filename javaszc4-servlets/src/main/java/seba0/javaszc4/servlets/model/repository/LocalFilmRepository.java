package seba0.javaszc4.servlets.model.repository;

import seba0.javaszc4.servlets.model.entities.Film;
import seba0.javaszc4.servlets.model.qualifier.Local;

import javax.inject.Singleton;
import java.util.*;

@Local
@Singleton
public class LocalFilmRepository implements FilmRepository {

    private final Set<Film> films = new HashSet<>();

    @Override
    public boolean insert(Film film) {
        return films.add(film);
    }

    @Override
    public Optional<Film> getByTitle(String title) {
        return films.stream()
                .filter(film -> Objects.equals(film.getTitle(), title))
                .findFirst();
    }

    @Override
    public Collection<Film> getAll() {
        return new HashSet<>(films);
    }

    @Override
    public boolean remove(Film film) {
        return films.remove(film);
    }
}
