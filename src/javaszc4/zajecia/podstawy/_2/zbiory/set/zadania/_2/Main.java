package javaszc4.zajecia.podstawy._2.zbiory.set.zadania._2;

import java.util.*;

public class Main {

    static List<Integer> randomedList(int upTo) {
        List<Integer> integers = new ArrayList<>(upTo);
        for(int i = 1; i <= upTo; i++) {
            integers.add(i);
        }
        Random r = new Random();
        List<Integer> out = new ArrayList<>(upTo);
        while (!integers.isEmpty()) {
            Integer i = integers.remove(r.nextInt(integers.size()));
            out.add(i);
        }
        return out;
    }


    static void print(Iterable i) {
        for (Object o : i) {
            System.out.print(o);
            System.out.print(' ');
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> ints = randomedList(1000);
        print(ints);

        Set<Integer> sort = new TreeSet<>(ints);
        print(sort);

    }
}
