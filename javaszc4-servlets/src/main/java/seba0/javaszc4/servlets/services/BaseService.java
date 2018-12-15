package seba0.javaszc4.servlets.services;

import seba0.javaszc4.servlets.model.repository.crud.CRUD;
import seba0.javaszc4.servlets.model.repository.crud.CRUDRepository;
import seba0.javaszc4.servlets.model.repository.crud.CRUDSession;

import java.util.List;

public abstract class BaseService<T> implements CRUD<T> {

    protected abstract CRUDRepository<T> getRepository();

    @Override
    public List<T> getAll() {
        try (CRUDSession<T> session = getRepository().openSession()) {
            return session.getAll();
        }
    }

    @Override
    public void add(T object) {
        try (CRUDSession<T> session = getRepository().openSession()) {
            session.add(object);
        }
    }

    @Override
    public T getById(long id) {
        try (CRUDSession<T> session = getRepository().openSession()) {
            return session.getById(id);
        }
    }

    @Override
    public void put(T object) {
        try (CRUDSession<T> session = getRepository().openSession()) {
            session.put(object);
        }
    }

    @Override
    public void remove(T object) {
        try (CRUDSession<T> session = getRepository().openSession()) {
            session.remove(object);
        }
    }
}
