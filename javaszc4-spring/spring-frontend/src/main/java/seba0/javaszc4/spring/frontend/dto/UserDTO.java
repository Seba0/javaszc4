package seba0.javaszc4.spring.frontend.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {

    private String login;
    private String password;
    private Set<String> roles;

}
