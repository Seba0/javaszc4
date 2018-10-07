package seba0.javaszc4.java8.functional.interfaces.supplier._2;

import seba0.javaszc4.java8.utils.TimeCounter;

import java.util.Random;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        TimeCounter.watch(() -> {
            Book book = getBookOfDay(() -> Book.NAMES.get(new Random().nextInt(Book.NAMES.size())));
            System.out.println(book);
        });
    }

    public static Book getBookOfDay(Supplier<String> nameSupplier) {
        return new Book(nameSupplier.get());
    }
}
