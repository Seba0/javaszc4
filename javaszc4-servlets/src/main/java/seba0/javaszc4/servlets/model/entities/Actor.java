package seba0.javaszc4.servlets.model.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Actor extends Person {

    private static final long serialVersionUID = 1L;
}
