package seba0.javaszc4.servlets.model.repository.crud;

import java.util.List;

public interface CRUD<T> {

    void add(T object);

    T getById(long id);

    List<T> getAll();

    void put(T object);

    void remove(T object);
}
