package seba0.javaszc4.malafirma.server.model;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JpaTest {

    private static final String PERSISTENCE_UNIT_NAME = "malafirma";
    private EntityManagerFactory factory;

    @BeforeTest
    public void setUp() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        Query q = em.createQuery("select m from Person m");
        boolean createNewEntries = q.getResultList().isEmpty();
        Assert.assertTrue(createNewEntries);

        if (createNewEntries) {
            Assert.assertTrue(createNewEntries);
            for (int i = 0; i < 40; i++) {
                Person person = new Person();
                person.setName("Jim_" + i);
                person.setName("Knopf_" + i);
                em.persist(person);
                em.persist(person);
            }
        }
        em.getTransaction().commit();
        em.close();
    }

    @Test
    public void checkAvailablePeople() {

        // now lets check the database and see if the created entries are there
        // create a fresh, new EntityManager
        EntityManager em = factory.createEntityManager();

        // Perform a simple query for all the Message entities
        Query q = em.createQuery("select m from Person m");

        // We should have 40 Persons in the database
        Assert.assertTrue(q.getResultList().size() == 40);

        em.close();
    }


    @Test(expectedExceptions = javax.persistence.NoResultException.class)
    public void deletePerson() {
        EntityManager em = factory.createEntityManager();
        // Begin a new local transaction so that we can persist a new entity
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT p FROM Person p WHERE p.name = :name AND p.surname = :surname");
        q.setParameter("name", "Jim_1");
        q.setParameter("surname", "Knopf_!");
        Person user = (Person) q.getSingleResult();
        em.remove(user);
        em.getTransaction().commit();
        Person person = (Person) q.getSingleResult();
        // Begin a new local transaction so that we can persist a new entity

        em.close();
    }
}
