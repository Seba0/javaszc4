package seba0.javaszc4.wielowatkowosc.synchronizacja._1;

public class Main {
    public static void main(String[] args) {
        Table t = new Table();

        Thread thread1 = new Thread(() -> t.printTable(5));
        Thread thread2 = new Thread(() -> t.printTable(100));

        thread1.start();
        thread2.start();
    }
}
