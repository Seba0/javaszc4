package seba0.javaszc4.servlets.services;

import org.apache.commons.codec.digest.DigestUtils;
import seba0.javaszc4.servlets.model.entities.User;
import seba0.javaszc4.servlets.model.repository.UserRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Singleton
public class UserService extends BaseService<User> {

    @Inject
    private UserRepository repository;

    @Override
    protected UserRepository getRepository() {
        return repository;
    }

    public List<User> findByName(String name) {
        return getAll().stream()
                .filter(user -> Objects.equals(user.getFirstName(), name))
                .collect(Collectors.toList());
    }

    public Optional<User> findUser(String login, String password) {
        try {
            final byte[] loginHash = DigestUtils.sha512(login);
            final byte[] passHash = DigestUtils.sha512(password);
            return getAll().stream()
                    .filter(user -> Arrays.equals(user.getLogin(), loginHash))
                    .filter(user -> Arrays.equals(user.getPassword(), passHash))
                    .findAny();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public boolean isUser(String login, String password) {
        return findUser(login, password).isPresent();
    }
}
