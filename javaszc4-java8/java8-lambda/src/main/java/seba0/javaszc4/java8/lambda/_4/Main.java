package seba0.javaszc4.java8.lambda._4;

import seba0.javaszc4.java8.utils.TimeCounter;

public class Main {
    public static void main(String[] args) {

        Compare magic = (a, b, c) -> a > b ? a > c ? a : c : b > c ? b : c;

        TimeCounter.watch(Integer.MAX_VALUE, () -> {
            magic.max(5, 6, 3);
        });


    }
}
