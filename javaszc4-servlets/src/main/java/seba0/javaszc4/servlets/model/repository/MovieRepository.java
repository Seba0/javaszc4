package seba0.javaszc4.servlets.model.repository;

import seba0.javaszc4.servlets.model.entities.Movie;
import seba0.javaszc4.servlets.model.repository.crud.CRUDRepository;

import javax.inject.Singleton;

@Singleton
public class MovieRepository extends CRUDRepository<Movie> {

    public MovieRepository() {
        super(Movie.class);
    }
}
