package seba0.javaszc4.hibernate.model.service;

import org.hibernate.Session;

import java.util.Collection;

public abstract class EntityService<T> implements CRUDService<T> {
    private final Session session;
    private final Class<T> entityType;

    public EntityService(Session session, Class<T> entityType) {
        this.session = session;
        this.entityType = entityType;
    }

    @Override
    public void create(T entity) {
        session.persist(entity);
    }

    @Override
    public T read(long id) {
        return session.get(entityType, id);
    }

    @Override
    public Collection<T> read() {
        return session.createQuery("FROM " + entityType.getSimpleName())
                .getResultList();
    }

    @Override
    public void update(T entity) {
        session.update(entity);
    }

    @Override
    public void delete(T entity) {
        session.delete(entity);
    }
}
