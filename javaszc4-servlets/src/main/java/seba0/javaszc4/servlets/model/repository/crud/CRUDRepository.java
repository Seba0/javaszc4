package seba0.javaszc4.servlets.model.repository.crud;

import org.hibernate.SessionFactory;
import seba0.javaszc4.servlets.listeners.HibernateContext;

public abstract class CRUDRepository<T> {

    private final Class<T> type;
    private final SessionFactory factory;

    protected CRUDRepository(Class<T> type) {
        this.type = type;
        factory = HibernateContext.getSessionFactory();
    }

    public CRUDSession<T> openSession() {
        return new CRUDSession<>(factory.openSession(), type);
    }
}
