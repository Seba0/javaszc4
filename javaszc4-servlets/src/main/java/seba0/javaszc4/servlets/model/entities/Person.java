package seba0.javaszc4.servlets.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Locale;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.CHAR)
public abstract class Person {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 35, nullable = false)
    private String firstName;

    @Column(length = 35, nullable = false)
    private String lastName;

    @Basic(optional = false)
    private Locale nationality;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birth;
}
