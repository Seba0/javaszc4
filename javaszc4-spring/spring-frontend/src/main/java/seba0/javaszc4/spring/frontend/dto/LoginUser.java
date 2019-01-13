package seba0.javaszc4.spring.frontend.dto;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.stream.Collectors;

public class LoginUser extends User {

    public LoginUser(UserDTO user) {
        super(user.getLogin(), user.getPassword(),
                user.getRoles().stream()
                        .map("ROLE_"::concat)
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toSet()));
    }
}
