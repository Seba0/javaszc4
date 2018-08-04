package javaszc4.zajecia.podstawy._2.zbiory.stos.zadania._2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> ints = new LinkedList<>();
        Random r = new Random();
        for(int i = 0; i < 10; i++) {
            ints.push(r.nextInt());
        }

        for (;!ints.isEmpty();) {
            System.out.println("Elementy");
            for (Integer i : ints) {
                System.out.println("\t" + i);
            }


            System.out.println("Size: " + ints.size());
            System.out.println("Pop: " + ints.pop());
            System.out.println("Size: " + ints.size());
        }

        System.out.println("Stos jest pusty");
    }
}
