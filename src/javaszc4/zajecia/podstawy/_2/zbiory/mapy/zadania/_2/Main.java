package javaszc4.zajecia.podstawy._2.zbiory.mapy.zadania._2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int size = 10;
        List<Film> filmy = new ArrayList<>(size);
        Random r = new Random();
        Gatunek[] values = Gatunek.values();
        for (int i = 1; i <= size; i++) {
            filmy.add(new Film("Film " + i, EnumSet.of(values[r.nextInt(values.length)]), "Reżyser " + i, 2000 + i));
        }

        for (Film f : filmy) {
            System.out.println(f);
        }

        Map<Gatunek, List<Film>> mapaFilmow = new HashMap<>();
        for (Film f : filmy) {
            for (Gatunek g : f.getGatunek()) {
                mapaFilmow.computeIfAbsent(g, k -> new ArrayList<>()).add(f);
            }
        }

        for (Gatunek g : mapaFilmow.keySet()) {
            System.out.println(g);
            for (Film f : mapaFilmow.get(g)) {
                System.out.print('\t');
                System.out.println(f);
            }
        }
    }
}
