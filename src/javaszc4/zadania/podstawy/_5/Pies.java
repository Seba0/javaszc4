package javaszc4.zadania.podstawy._5;

public class Pies extends Zwierze {

    public Pies(String imie, Integer wiek) {
        super(imie, wiek);
    }

    @Override
    public void powiedzKimJestes() {
        System.out.println("Jestem Pies");
    }
}
