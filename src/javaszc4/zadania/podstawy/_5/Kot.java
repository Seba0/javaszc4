package javaszc4.zadania.podstawy._5;

public class Kot extends Zwierze {

    public Kot(String imie, Integer wiek) {
        super(imie, wiek);
    }

    @Override
    public void powiedzKimJestes() {
        System.out.println("Jestem Kot");
    }
}
