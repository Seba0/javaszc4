package seba0.javaszc4.spring.frontend.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import seba0.javaszc4.spring.frontend.dto.UserForm;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return UserForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidateUnit<UserForm> valid = new ValidateUnit<>((UserForm) o, errors, "userForm");

        valid.size(UserForm::getFirstName, "firstName", 3, 128);
        valid.size(UserForm::getLastName, "lastName", 3, 128);
        valid.size(UserForm::getLogin, "login", 4, 128);
        valid.size(UserForm::getPassword, "password", 4, 128);

        valid.equals(UserForm::getPasswordConfirm, UserForm::getPassword, "passwordConfirm");
    }
}
