package javaszc4.zajecia.podstawy._3.generyki._3;

public class Pies extends Zwierze {
    @Override
    public void kimJestem() {
        System.out.println("Jestem " + getClass().getSimpleName());
    }
}
