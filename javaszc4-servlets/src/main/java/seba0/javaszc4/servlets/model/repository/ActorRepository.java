package seba0.javaszc4.servlets.model.repository;

import seba0.javaszc4.servlets.model.entities.Actor;
import seba0.javaszc4.servlets.model.repository.crud.CRUDRepository;

import javax.inject.Singleton;

@Singleton
public class ActorRepository extends CRUDRepository<Actor> {

    public ActorRepository() {
        super(Actor.class);
    }
}
