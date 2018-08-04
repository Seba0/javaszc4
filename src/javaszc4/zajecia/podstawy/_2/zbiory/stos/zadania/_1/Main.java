package javaszc4.zajecia.podstawy._2.zbiory.stos.zadania._1;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Deque<String> imiona = new LinkedList<>();
        imiona.push("Ania");
        imiona.push("Justyna");
        imiona.push("Ola");
        imiona.push("Patrycja");
        imiona.push("Marta");
        imiona.push("Wiktoria");
        imiona.push("Karolina");
        imiona.push("Martyna");
        imiona.push("Julia");
        imiona.push("Weronika");

        while (!imiona.isEmpty()) {
            System.out.println(imiona.pop());
        }
    }
}
