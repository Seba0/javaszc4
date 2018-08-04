package javaszc4.zajecia.podstawy._2.zbiory.mapy.zadania._1;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<BigInteger, String> marki = new HashMap<>();
        marki.put(BigInteger.valueOf(50), "Honda");
        marki.put(BigInteger.valueOf(300), "BMW");
        marki.put(BigInteger.valueOf(9), "Aaglander");
        marki.put(BigInteger.valueOf(23), "Amuza");
        marki.put(BigInteger.valueOf(203), "Fiat");

        for (Map.Entry<BigInteger, String> e : marki.entrySet()) {
            System.out.println(e.getKey().toString() + ": " + e.getValue());
        }
        System.out.println();
        marki.remove(new BigInteger("9"));

        if(marki.containsKey(new BigInteger("9"))) {
            System.out.println("TAK");
        } else {
            System.out.println("NIE");
        }

        if(marki.containsValue("Aaglander")) {
            System.out.println("TAK");
        } else {
            System.out.println("NIE");
        }

        for (Map.Entry<BigInteger, String> e : marki.entrySet()) {
            System.out.println(e.getKey().toString() + ": " + e.getValue());
        }

        marki.clear();
    }
}
