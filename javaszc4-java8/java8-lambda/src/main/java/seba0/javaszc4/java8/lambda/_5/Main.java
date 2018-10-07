package seba0.javaszc4.java8.lambda._5;

import seba0.javaszc4.java8.utils.TimeCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        TimeCounter.watch(() ->
                ListPresenter.showList(
                        IntStream.rangeClosed(1, 100)
                                .collect(ArrayList::new, List::add, List::addAll),
                        item -> System.out.println("---" + item + "---")
                )
        );
    }
}
