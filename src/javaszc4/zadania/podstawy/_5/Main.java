package javaszc4.zadania.podstawy._5;

import javaszc4.zadania.podstawy._5.rasy.RasaKota;
import javaszc4.zadania.podstawy._5.rasy.RasaPsa;

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
    }
}
