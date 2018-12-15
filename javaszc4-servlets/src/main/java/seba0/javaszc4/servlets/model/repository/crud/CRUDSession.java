package seba0.javaszc4.servlets.model.repository.crud;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CRUDSession<T> implements CRUD<T>, AutoCloseable {

    private final Session session;
    private final Transaction transaction;
    private Class<T> type;

    CRUDSession(Session session, Class<T> type) {
        this.session = session;
        this.transaction = session.beginTransaction();
        this.type = type;
    }

    @Override
    public void add(T object) {
        session.save(object);
    }

    @Override
    public T getById(long id) {
        return session.get(type, id);
    }

    @Override
    public List<T> getAll() {
        return session.createQuery("from " + type.getSimpleName()).list();
    }

    @Override
    public void put(T object) {
        session.update(object);
    }

    @Override
    public void remove(T object) {
        session.delete(object);
    }

    public Transaction getTransaction() {
        return transaction;
    }

    @Override
    public void close() {
        transaction.commit();
        session.close();
    }


}
