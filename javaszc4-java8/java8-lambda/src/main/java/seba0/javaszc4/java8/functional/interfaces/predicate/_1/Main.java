package seba0.javaszc4.java8.functional.interfaces.predicate._1;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Values divided by 5");
        IntStream.rangeClosed(1, 100)
                .filter(i -> i % 5 == 0)
                .forEach(System.out::println);

    }
}
