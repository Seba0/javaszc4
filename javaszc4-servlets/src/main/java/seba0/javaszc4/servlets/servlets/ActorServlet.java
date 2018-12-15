package seba0.javaszc4.servlets.servlets;

import seba0.javaszc4.servlets.model.entities.Actor;
import seba0.javaszc4.servlets.model.repository.ActorRepository;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "actor", urlPatterns = "/actor/*")
public class ActorServlet extends BaseServlet<Actor> {

    @Inject
    private ActorRepository repository;

    public ActorServlet() {
        super(Actor.class);
    }

    @Override
    protected ActorRepository getRepository() {
        return repository;
    }
}
