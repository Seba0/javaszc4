package seba0.javaszc4.wielowatkowosc.prerwania._1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inser number to count to number: ");
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.print("\nInser count number: ");
        }
        int countTo = scanner.nextInt();

        Thread runThread1 = new Thread(new CounterRunnable(countTo, 1500));
        Thread thrThread2 = new CounterThread(countTo, 2000);

        runThread1.start();
        thrThread2.start();

        Thread.sleep(10000);

        thrThread2.interrupt();
    }
}
