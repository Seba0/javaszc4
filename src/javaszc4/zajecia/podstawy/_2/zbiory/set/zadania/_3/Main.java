package javaszc4.zajecia.podstawy._2.zbiory.set.zadania._3;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Ksiazka> set = new HashSet<>();
        set.add(new Ksiazka("Jan", "Kowalski", 154));
        set.add(new Ksiazka("Marian", "Wiśniewski", 268));
        set.add(new Ksiazka("Jan", "Kowalski", 154));

        for(Ksiazka k : set) {
            System.out.println(k);
        }
    }
}
