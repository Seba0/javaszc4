package javaszc4.zajecia.podstawy._3.generyki._1_2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Banan> banans = new PojemnikNaOwoce<>();
        List<Jablko> jablka = new PojemnikNaOwoce<>();
        List<Pomarancza> pomarancze = new PojemnikNaOwoce<>();
        List<Owoc> owoce = new PojemnikNaOwoce<>();

        owoce.addAll(pomarancze);
        owoce.addAll(jablka);
        owoce.addAll(banans);
    }
}
