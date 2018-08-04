package javaszc4.zajecia.podstawy._2.zbiory.set.zadania._1;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<String> imiona = new TreeSet<>();
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("Podaj imie: ");
            String imie = s.next();
            if ("END".equalsIgnoreCase(imie)) {
                break;
            } else if (Imiona.isImie(imie)) {
                imiona.add(imie);
            }
        }
        for (String imie : imiona) {
            System.out.println(imie);
        }
    }
}
