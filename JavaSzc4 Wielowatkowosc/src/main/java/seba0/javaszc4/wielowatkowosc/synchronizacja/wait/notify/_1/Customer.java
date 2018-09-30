package seba0.javaszc4.wielowatkowosc.synchronizacja.wait.notify._1;

public class Customer {
    private int money;

    public Customer(int money) {
        this.money = money;
    }

    synchronized void withDraw(int money) {
        System.out.println("WithDraw.");
        try {
            while (!checkMoney(money)) {
                System.out.println("No money");
                wait();
            }
            System.out.println("Windrawed");
            this.money -= money;
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean checkMoney(int money) {
        return this.money >= money;
    }

    synchronized void deposit(int money) {
        this.money += money;
        notify();
    }

    public static void main(String[] args) {

        Customer c = new Customer(100);

        new Thread(() -> c.withDraw(300)).start();
        new Thread(() -> c.deposit(10)).start();
    }
}
