package seba0.javaszc4.servlets.model.repository;

import seba0.javaszc4.servlets.model.entities.Director;

import java.util.Collection;
import java.util.Optional;

public interface DirectorRepository {

    boolean insert(Director director);

    Optional<Director> getByName(String name);

    Collection<Director> getAll();

    boolean remove(Director director);
}
