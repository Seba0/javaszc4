package seba0.javaszc4.spring.backend.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@NoArgsConstructor
@Document("Customers")
public class Customer {

    @Id
    private String id;

    @NonNull
    @NotBlank(message = "Login is required")
    @Indexed(unique = true)
    @Size(min = 5, message = "Login should have at last 5 characters")
    private String login;

    @NonNull
    private String password;

    @NonNull
    @NotBlank(message = "First name is required")
    @Size(min = 2, message = "First name should have at last 2 characters")
    private String firstName;

    @NonNull
    @NotBlank(message = "Last name is required")
    @Size(min = 2, message = "Last name should have at last 2 characters")
    private String lastName;

    @NonNull
    @DBRef
    private Brand brand;

    @NonNull
    private Set<String> roles;
}
