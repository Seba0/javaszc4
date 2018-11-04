package seba0.javaszc4.hibernate.model.service;

import java.util.Collection;

public interface CRUDService<T> {
    void create(T entity);

    default void create(Iterable<T> entities) {
        entities.forEach(this::create);
    }

    T read(long id);

    Collection<T> read();

    void update(T entity);

    default void update(Iterable<T> entities) {
        entities.forEach(this::update);
    }

    void delete(T entity);

    default void delete(Iterable<T> entities) {
        entities.forEach(this::delete);
    }
}
