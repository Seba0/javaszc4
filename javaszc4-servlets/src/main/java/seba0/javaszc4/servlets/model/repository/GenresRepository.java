package seba0.javaszc4.servlets.model.repository;

import seba0.javaszc4.servlets.model.entities.Genres;
import seba0.javaszc4.servlets.model.repository.crud.CRUDRepository;

import javax.inject.Singleton;

@Singleton
public class GenresRepository extends CRUDRepository<Genres> {

    public GenresRepository() {
        super(Genres.class);
    }
}
