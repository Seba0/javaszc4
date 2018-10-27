package seba0.javaszc4.java8.functional.interfaces.consumer._1;

import seba0.javaszc4.java8.utils.NamesList;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = new NamesList(i -> "      " + (i * i) + "      ", 100);
        names.forEach(System.out::println);
        names.stream()
                .map(String::trim)
                .forEach(System.out::println);
    }
}
