package seba0.javaszc4.java8.functional.interfaces.consumer._2;

import lombok.Data;

import java.util.Set;

@Data
public class Movie {
    private String title;
    private Set<String> genres;
    private String authot;
    private int year;
}
