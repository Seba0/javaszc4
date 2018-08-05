package javaszc4.zajecia.podstawy._3.zbiory.kolejki.zadania._1;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int size = 20;
        Queue<Integer> kolejka = new LinkedList<>();
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            kolejka.add(r.nextInt(100) + 1);
        }
        System.out.println("Kolejka:");
        for (Integer i : kolejka) {
            System.out.print('\t');
            System.out.println(i);
        }
        System.out.println("Wielkość kolejki: " + kolejka.size());
        System.out.println("Pierwszy element: " + kolejka.peek());
        System.out.println("Usunięty element: " + kolejka.poll());
        System.out.println("Pierwszy element: " + kolejka.peek());
        System.out.println("Zdejmowanie elementów:");
        while (!kolejka.isEmpty()) {
            System.out.print('\t');
            System.out.println(kolejka.poll());
        }
    }
}
