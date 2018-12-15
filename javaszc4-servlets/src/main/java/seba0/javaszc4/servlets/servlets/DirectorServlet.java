package seba0.javaszc4.servlets.servlets;

import seba0.javaszc4.servlets.model.entities.Director;
import seba0.javaszc4.servlets.model.repository.DirectorRepository;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "director", urlPatterns = "/director/*")
public class DirectorServlet extends BaseServlet<Director> {

    @Inject
    private DirectorRepository repository;

    public DirectorServlet() {
        super(Director.class);
    }

    @Override
    protected DirectorRepository getRepository() {
        return repository;
    }
}
