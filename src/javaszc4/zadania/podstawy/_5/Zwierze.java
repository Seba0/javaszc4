package javaszc4.zadania.podstawy._5;

public class Zwierze {

    private final String imie;
    private final Integer wiek;

    public Zwierze(String imie, Integer wiek) {
        this.imie = imie;
        this.wiek = wiek;
    }

    @Override
    public String toString() {
        return "Zwierze{imie=" + imie + ", wiek=" + wiek + "}";
    }
}
