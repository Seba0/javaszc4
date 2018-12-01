package seba0.javaszc4.servlets.cdi.model.entities;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Car {

    private Long id;
    private String name;
    private String model;
}
