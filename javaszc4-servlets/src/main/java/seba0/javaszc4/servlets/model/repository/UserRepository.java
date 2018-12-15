package seba0.javaszc4.servlets.model.repository;

import seba0.javaszc4.servlets.model.entities.User;
import seba0.javaszc4.servlets.model.repository.crud.CRUDRepository;

import javax.inject.Singleton;

@Singleton
public class UserRepository extends CRUDRepository<User> {

    public UserRepository() {
        super(User.class);
    }
}
