package seba0.javaszc4.wzorce.nullobject.user;

import java.util.*;

public class UserRepository {

    private static final Map<UUID, User> users = new HashMap<>();

    public boolean create(UUID id, User user) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(user);
        if (user == User.NULL
                || users.containsKey(id)
                || users.containsValue(user)) {
            return false;
        }
        users.put(id, user);
        return true;
    }

    public Collection<Map.Entry<UUID, User>> read() {
        return users.entrySet();
    }

    public User read(UUID id) {
        Objects.requireNonNull(id);
        return users.getOrDefault(id, User.NULL);
    }

    public boolean update(UUID id, User user) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(user);
        if (Objects.equals(user, User.NULL)
                || users.containsKey(id)
                || !users.containsValue(user)) {
            return false;
        }
        users.put(id, user);
        return true;
    }

    public User delete(UUID id) {
        Objects.requireNonNull(id);
        User user = users.remove(id);
        if (Objects.isNull(user)) {
            return User.NULL;
        }
        return user;
    }
}
