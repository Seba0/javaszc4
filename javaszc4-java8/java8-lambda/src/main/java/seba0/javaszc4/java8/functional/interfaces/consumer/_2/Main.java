package seba0.javaszc4.java8.functional.interfaces.consumer._2;


import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        Consumer<Movie> print = movie -> {
            System.out.println("Title: " + movie.getTitle());
            System.out.print("Genres: ");
            movie.getGenres().forEach(genre -> System.out.print(" " + genre));
            System.out.println();
            System.out.println("Author: " + movie.getAuthot());
            System.out.println("Year: " + movie.getYear());
        };


        Movie movie = new Movie();
        movie.setTitle("T");
        movie.setAuthot("A");
        movie.setGenres(new HashSet<>(Arrays.asList("GA", "GB", "GC", "GD")));
        movie.setYear(2000);


        showMovie(print, movie);
    }

    public static void showMovie(Consumer<Movie> consumer, Movie movie) {
        consumer.accept(movie);
    }
}
