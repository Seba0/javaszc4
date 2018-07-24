package javaszc4.zadania.podstawy._5.klasy_dziedziczenie;

import javaszc4.zadania.podstawy._5.klasy_dziedziczenie.rasy.RasaKota;

public class Kot extends Zwierze {

    private final RasaKota rasa;

    public Kot(String imie, Integer wiek, RasaKota rasa) {
        super(imie, wiek);
        this.rasa = rasa;
    }

    public RasaKota getRasa() {
        return rasa;
    }

    @Override
    public void powiedzKimJestes() {
        System.out.println("Jestem Kot");
    }
}
