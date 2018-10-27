package seba0.javaszc4.java8.lambda._2;

public class Main {
    public static void main(String[] args) {
        Provider p = (lastName, firstName) -> lastName + " " + firstName;
        System.out.println(p.provide("Jan", "Kowalski"));
        StringBuilder sb = new StringBuilder();
        sb.append("");
        "".concat("");
    }
}
