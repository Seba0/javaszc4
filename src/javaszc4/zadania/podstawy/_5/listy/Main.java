package javaszc4.zadania.podstawy._5.listy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Listy
        // Zadanie 6
        int wielkoscListy = 10;
        List<String> listaZElementamiTypuString = new ArrayList<>(wielkoscListy);

        for (int i = 1; i <= wielkoscListy; i++) {
            listaZElementamiTypuString.add("element " + i);
        }

        for (int i = 0; i < wielkoscListy; i++) {
            String element = listaZElementamiTypuString.get(i);
            System.out.print(element + ' ');
        }
        System.out.println();

        for (String element : listaZElementamiTypuString) {
            System.out.print(element + ' ');
        }
        System.out.println();

        // Zadanie 7
        List<Integer> listaZElementamiTypuInteger = new ArrayList<>(Arrays.asList(
                1, 2, 3, 4, 5,
                6, 7, 8, 9, 10,
                11, 12, 13, 14, 15));

        for (Integer element : listaZElementamiTypuInteger) {
            System.out.print(element + " ");
        }
        System.out.println();

        System.out.println(listaZElementamiTypuInteger.size());

        listaZElementamiTypuInteger.remove(0);
        listaZElementamiTypuInteger.remove(listaZElementamiTypuInteger.size() - 1);

        System.out.println(listaZElementamiTypuInteger.size());

        // Zadanie 8
        int iloscKsiazek = 11;
        List<Ksiazka> ksiazki = new ArrayList<>(iloscKsiazek);

        for (int i = 1; i <= iloscKsiazek; i++) {
            Ksiazka ksiazka = new Ksiazka();
            ksiazka.setTytul("Wielka księga nr " + i);
            ksiazka.setAutor("Autor nieznany nr " + i / 3);
            ksiazka.setLiczbaStron(i * 23);
            ksiazka.setWydawnictwo("Wydawnictwo Inne");
            ksiazki.add(ksiazka);
        }

        for (Ksiazka ksiazka : ksiazki) {
            System.out.println(ksiazka);
        }

        ksiazki.remove(iloscKsiazek / 2);

        System.out.println(ksiazki.size());

        for (Ksiazka ksiazka : ksiazki) {
            if (ksiazka.getLiczbaStron() > 200) {
                System.out.println(ksiazka);
            }
        }

        // Zadanie 9
        int iloscKsiazek2 = 4;
        List<Ksiazka> ksiazki2 = new ArrayList<>(iloscKsiazek2);

        for (int i = iloscKsiazek + 1; i <= iloscKsiazek + iloscKsiazek2; i++) {
            Ksiazka ksiazka = new Ksiazka();
            ksiazka.setTytul("Wielka księga nr " + i);
            ksiazka.setAutor("Autor prawie nieznany nr " + i / 3);
            ksiazka.setLiczbaStron(i * 23);
            ksiazka.setWydawnictwo("Wydawnictwo Nowe");
            ksiazki2.add(ksiazka);
        }

        ksiazki.addAll(ksiazki2);

        System.out.println(ksiazki.size());

        for (Ksiazka ksiazka : ksiazki) {
            System.out.println(ksiazka);
        }

    }
}
