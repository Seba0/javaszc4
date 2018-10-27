package seba0.javaszc4.wielowatkowosc.synchronizacja.wait.notify._2;

import java.util.HashMap;
import java.util.Map;

public class Shop {

    private final Map<String, Integer> items = new HashMap<>();

    public synchronized String buy(String item) {
        System.out.println("Buing " + item);
        try {
            int count;
            while ((count = items.getOrDefault(item, 0)) == 0) {
                wait();
            }
            items.put(item, count - 1);
        } catch (InterruptedException e) {
            return null;
        }
        System.out.println("Selled " + item);
        return item;
    }

    public synchronized void delivery(String item, int count) {
        if (count > 0) {
            System.out.println("Deliver " + item + " count " + count);
            count = items.getOrDefault(item, 0) + count;
            items.put(item, count);
            notifyAll();
        }
    }

    public static void main(String[] args) {

        Shop shop = new Shop();

        String[] items = {"Desktop", "Notebook", "Mouse"};

        for (int i = 0; i < 5; i++) {
            for (String item : items)
                new Thread(() -> shop.buy(item)).start();
        }


        new Thread(() -> shop.delivery("Desktop", 5)).start();
        new Thread(() -> shop.delivery("Notebook", 3)).start();
        new Thread(() -> shop.delivery("Mouse", 1)).start();

    }
}
