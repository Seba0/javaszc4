package seba0.javaszc4.java8.functional.interfaces.supplier._3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Supplier;

public class Main {
    private static final DateFormat format = new SimpleDateFormat("HH:mm:ss");

    public static void main(String[] args) {
        printTime(() -> format.format(new Date()));
    }

    public static void printTime(Supplier<String> supplier) {
        System.out.println(supplier.get());
    }
}
