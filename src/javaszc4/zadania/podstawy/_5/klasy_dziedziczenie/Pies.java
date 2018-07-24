package javaszc4.zadania.podstawy._5.klasy_dziedziczenie;

import javaszc4.zadania.podstawy._5.klasy_dziedziczenie.rasy.RasaPsa;

public class Pies extends Zwierze {

    private final RasaPsa rasa;

    public Pies(String imie, Integer wiek, RasaPsa rasa) {
        super(imie, wiek);
        this.rasa = rasa;
    }

    public RasaPsa getRasa() {
        return rasa;
    }

    @Override
    public void powiedzKimJestes() {
        System.out.println("Jestem Pies");
    }
}
