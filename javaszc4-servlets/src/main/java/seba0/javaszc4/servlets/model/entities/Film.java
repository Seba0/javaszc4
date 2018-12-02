package seba0.javaszc4.servlets.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Film {

    private String title;
    private Director director;
    private int year;
}
