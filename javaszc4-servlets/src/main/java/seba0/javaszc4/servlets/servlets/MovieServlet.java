package seba0.javaszc4.servlets.servlets;

import seba0.javaszc4.servlets.model.entities.Movie;
import seba0.javaszc4.servlets.model.repository.MovieRepository;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "movie", urlPatterns = "/movie/*")
public class MovieServlet extends BaseServlet<Movie> {

    @Inject
    private MovieRepository repository;

    public MovieServlet() {
        super(Movie.class);
    }

    @Override
    protected MovieRepository getRepository() {
        return repository;
    }
}
