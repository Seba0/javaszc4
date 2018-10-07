package seba0.javaszc4.java8.lambda._1;

public class Main {
    public static void main(String[] args) {
        Action a = new Action() {
            @Override
            public void execute(int x, int y) {
                System.out.println(x);
                System.out.println(y);
            }
        };
        Action b = (int x, int y) -> {
            System.out.println(x);
            System.out.println(y);
        };
        Action c = (x, y) -> {
            System.out.println(x);
            System.out.println(y);
        };
        a.execute(1, 2);
        b.execute(3, 4);
        c.execute(5, 6);

        Test t = () -> () -> () -> () -> () -> () -> () -> () -> () -> () -> () -> () -> () -> () -> () -> () -> () -> () -> () -> () -> () -> () -> () -> () -> () -> () -> {
            throw new RuntimeException();
        };
        "a".concat("dd");
        while (t != null)
            t = t.test();
    }
}
