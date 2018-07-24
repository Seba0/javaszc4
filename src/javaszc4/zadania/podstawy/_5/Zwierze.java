package javaszc4.zadania.podstawy._5;

public class Zwierze {

    private final String imie;
    private final Integer wiek;

    public Zwierze(String imie, Integer wiek) {
        this.imie = imie;
        this.wiek = wiek;
    }

    public void powiedzKimJestes() {
        System.out.println("Jestem Zwierzę");
    }

    @Override
    public String toString() {
        return "Zwierze{imie=" + imie + ", wiek=" + wiek + "}";
    }
}
