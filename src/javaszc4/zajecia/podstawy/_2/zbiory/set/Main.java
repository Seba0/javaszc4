package javaszc4.zajecia.podstawy._2.zbiory.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Integer> payment = new TreeSet<>();
        payment.add(1500);
        payment.add(1450);
        payment.add(5000);
        payment.add(4500);

        payment = new HashSet<>(payment);

        System.out.println(payment);

        Set<String> cities = new HashSet<>();
        cities.add("Szczecin");
        cities.add("Warszawa");
        cities.add("Wrocław");
        cities.add("Wrocław");
        cities.add("Wrocław");

        cities = new TreeSet<>(cities);

        System.out.println(cities);
    }
}
