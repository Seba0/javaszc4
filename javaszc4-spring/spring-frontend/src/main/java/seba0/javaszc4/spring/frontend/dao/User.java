package seba0.javaszc4.spring.frontend.dao;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@NoArgsConstructor
@Validated()
public class User {

    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String passwordConfirm;
}
