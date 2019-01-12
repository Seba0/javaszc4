package seba0.javaszc4.spring.frontend.dao;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Validated
public class UserForm {

    @NotNull
    @Size(min = 2, max = 35)
    private String firstName;

    @NotNull
    @Size(min = 2, max = 35)
    private String lastName;

    @NotNull
    @Size(min = 5, max = 35)
    private String login;

    @NotNull
    @Size(min = 5)
    private String password;

    @NotNull
    @Size(min = 5)
    private String passwordConfirm;
}
