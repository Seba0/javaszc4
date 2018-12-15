package seba0.javaszc4.servlets.listeners;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class HibernateContext implements ServletContextListener {

    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration().configure();
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sessionFactory = buildSessionFactory();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if (sessionFactory != null)
            sessionFactory.close();
    }
}
