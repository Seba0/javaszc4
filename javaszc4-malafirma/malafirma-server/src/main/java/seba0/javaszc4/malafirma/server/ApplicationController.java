package seba0.javaszc4.malafirma.server;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ApplicationController {

    private static final String PERSISTENCE_UNIT_NAME = "malafirma";
    private static EntityManagerFactory factory;


    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

    }
}
