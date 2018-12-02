package seba0.javaszc4.wzorce.nullobject.user;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;

import static org.testng.Assert.*;

public class UserRepositoryTest {

    private UserRepository repository;
    private UUID uuid;
    private User user;

    @BeforeClass
    public void initRepository() {
        repository = new UserRepository();
        uuid = UUID.randomUUID();
        user = new User("Name", "Surname");

        assertTrue(repository.create(uuid, user));
        assertEquals(repository.read(uuid), user);
    }

    @Test
    public void testGetNonExistUser() {
        // given
        UUID uuid = UUID.randomUUID();

        // when
        User result = repository.read(uuid);

        // then
        assertNotNull(result);
        assertEquals(result, User.NULL);
    }


    @Test
    private void testCreateUser() {
        // given
        UUID uuid = UUID.randomUUID();
        User user = new User("Name New", "Surname New");

        // when
        boolean result = repository.create(uuid, user);

        // then
        assertTrue(result);
    }


    @Test
    private void testReadUser() {

        // when
        User result = repository.read(uuid);

        // then
        assertNotNull(result);
        assertEquals(result, user);
    }
}