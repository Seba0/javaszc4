package seba0.javaszc4.servlets.model.repository;

import seba0.javaszc4.servlets.model.entities.Director;
import seba0.javaszc4.servlets.model.qualifier.Local;

import javax.inject.Singleton;
import java.util.*;

@Local
@Singleton
public class LocalDirectorRepository implements DirectorRepository {

    private final Set<Director> directors = new HashSet<>();

    @Override
    public boolean insert(Director director) {
        return directors.add(director);
    }

    @Override
    public Optional<Director> getByName(String name) {
        return directors.stream()
                .filter(director -> Objects.equals(director.getName(), name))
                .findFirst();
    }

    @Override
    public Collection<Director> getAll() {
        return new HashSet<>(directors);
    }

    @Override
    public boolean remove(Director director) {
        return directors.remove(director);
    }
}
