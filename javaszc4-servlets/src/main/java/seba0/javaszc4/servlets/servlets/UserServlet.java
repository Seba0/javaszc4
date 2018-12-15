package seba0.javaszc4.servlets.servlets;

import seba0.javaszc4.servlets.model.entities.User;
import seba0.javaszc4.servlets.model.repository.UserRepository;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "user", urlPatterns = "/user/*")
public class UserServlet extends BaseServlet<User> {

    @Inject
    private UserRepository repository;

    public UserServlet() {
        super(User.class);
    }

    @Override
    protected UserRepository getRepository() {
        return repository;
    }
}
