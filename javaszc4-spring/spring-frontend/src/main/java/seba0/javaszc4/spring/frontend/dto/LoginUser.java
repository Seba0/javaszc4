package seba0.javaszc4.spring.frontend.dto;

import org.springframework.security.core.userdetails.User;

import java.util.Collections;

public class LoginUser extends User {

    public LoginUser(UserDTO user) {
        super(user.getLogin(), user.getPassword(), Collections.emptyList());
    }
}
