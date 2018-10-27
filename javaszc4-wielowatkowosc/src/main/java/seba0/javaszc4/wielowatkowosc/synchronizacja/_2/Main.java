package seba0.javaszc4.wielowatkowosc.synchronizacja._2;

public class Main {
    public static void main(String[] args) {
        Station station = new Station("A");
        Train regio = new Train("REGIO", station);
        Train itc = new Train("ITC", station);

        regio.start();
        itc.start();
    }
}
