package seba0.javaszc4.wielowatkowosc.synchronizacja.deadlock._1;

public class Person {

    public synchronized void bow(Person person) {
        System.out.println("Bow " + person.getClass().getSimpleName());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        person.bowBack(this);
    }

    public synchronized void bowBack(Person person) {
        System.out.println("Bow back " + person.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        Person a = new Person();
        Person b = new Person();

        new Thread(() -> System.out.println("Test")
        ).start();

        new Thread(() -> {
            a.bow(b);
        }).start();
        new Thread(() -> {
            b.bow(a);
        }).start();
    }
}
