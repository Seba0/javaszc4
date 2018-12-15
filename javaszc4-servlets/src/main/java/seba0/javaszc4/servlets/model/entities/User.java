package seba0.javaszc4.servlets.model.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("U")
public class User extends Person {

    private static final long serialVersionUID = 1L;

    @Column(unique = true, nullable = false, length = 64)
    private byte[] login;

    @Column(nullable = false, length = 64)
    private byte[] password;

}
