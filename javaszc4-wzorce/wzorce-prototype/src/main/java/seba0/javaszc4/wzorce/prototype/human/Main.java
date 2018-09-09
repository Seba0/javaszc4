package seba0.javaszc4.wzorce.prototype.human;

public class Main {
    public static void main(String[] args) throws Exception {
        Human marcin = new Human();
        marcin.setAge(11);
        marcin.setName("Marcin");
        System.out.println(marcin);
        Human piotr = (Human) marcin.clone();
        System.out.println(piotr);
        piotr.setName("Piotr");
        piotr.setAge(12);
        System.out.println(marcin);
        System.out.println(piotr);
    }
}
