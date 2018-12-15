package seba0.javaszc4.servlets.model.repository;

import seba0.javaszc4.servlets.model.entities.Director;
import seba0.javaszc4.servlets.model.repository.crud.CRUDRepository;

import javax.inject.Singleton;

@Singleton
public class DirectorRepository extends CRUDRepository<Director> {

    public DirectorRepository() {
        super(Director.class);
    }
}
