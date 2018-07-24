package javaszc4.zadania.podstawy._5;

import javaszc4.zadania.podstawy._5.rasy.RasaKota;
import javaszc4.zadania.podstawy._5.rasy.RasaPsa;

import java.util.ArrayList;
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

    }
}
