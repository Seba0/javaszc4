package javaszc4.zadania.podstawy._5;

import javaszc4.zadania.podstawy._5.rasy.RasaKota;
import javaszc4.zadania.podstawy._5.rasy.RasaPsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Klasy i dziedziczenie
        // Zadanie 1
        Pies pies = new Pies("Pesek", 2, RasaPsa.AIREDALE_TERRIER);
        Kot kot = new Kot("Kotek", 3, RasaKota.KOT_MANX);

        System.out.println(pies);
        System.out.println(kot);

        // Zadanie 2
        pies.powiedzKimJestes();
        kot.powiedzKimJestes();

        // Zadanie 4
        Czlowiek czlowiekZPsem = new Czlowiek("Jan", "Kowalski");
        Czlowiek czlowiekZKotem = new Czlowiek("Marek", "Wiśniewsi");

        czlowiekZPsem.setZwierze(pies);
        czlowiekZKotem.setZwierze(kot);

        // Zadanie 5
        czlowiekZPsem.przedstawSie();
        czlowiekZKotem.przedstawSie("Kocham zwierzęta");

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
        List<Integer> listaZElementamiTypuInteger = Arrays.asList(
                1, 2, 3, 4, 5,
                6, 7, 8, 9, 10,
                11, 12, 13, 14, 15);

        for(Integer element : listaZElementamiTypuInteger) {
            System.out.print(element + ' ');
        }
        System.out.println();

        System.out.println(listaZElementamiTypuInteger.size());

        listaZElementamiTypuInteger.remove(0);
        listaZElementamiTypuInteger.remove(listaZElementamiTypuInteger.size() - 1);

        System.out.println(listaZElementamiTypuInteger.size());
    }
}
