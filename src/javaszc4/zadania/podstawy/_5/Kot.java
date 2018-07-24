package javaszc4.zadania.podstawy._5;

import javaszc4.zadania.podstawy._5.rasy.RasaKota;

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
