package seba0.javaszc4.servlets.servlets;

import seba0.javaszc4.servlets.model.entities.Genres;
import seba0.javaszc4.servlets.model.repository.GenresRepository;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "genres", urlPatterns = "/genres/*")
public class GenresServlet extends BaseServlet<Genres> {

    @Inject
    private GenresRepository repository;

    public GenresServlet() {
        super(Genres.class);
    }

    @Override
    protected GenresRepository getRepository() {
        return repository;
    }
}
