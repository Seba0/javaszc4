package seba0.javaszc4.wielowatkowosc.synchronizacja._1;

public class Table {

    public void printTable(int n) {
        System.out.println("Table: " + n);
        synchronized (this) {
            for (int i = 1; i <= 5; i++) {
                System.out.println(i * (n + 2));
                synchronized (this) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
