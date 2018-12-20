package seba0.javaszc4.spring.frontend.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import seba0.javaszc4.spring.frontend.dao.User;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidateUnit<User> valid = new ValidateUnit<>((User) o, errors, "userForm");

        valid.size(User::getFirstName, "firstName", 3, 128);
        valid.size(User::getLastName, "lastName", 3, 128);
        valid.size(User::getLogin, "login", 4, 128);
        valid.size(User::getPassword, "password", 4, 128);

        valid.equals(User::getPasswordConfirm, User::getPassword, "passwordConfirm");
    }
}
