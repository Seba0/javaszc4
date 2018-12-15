package seba0.javaszc4.servlets.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Movie {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    private Director director;

    @Column(nullable = false)
    private int year;

    @ManyToMany
    private Set<Actor> actors;
}
