package seba0.javaszc4.wielowatkowosc.synchronizacja._2;

public class Station {

    private final String name;

    public Station(String name) {
        this.name = name;
    }

    public synchronized void atTheStation(Train train) {
        System.out.println(train.getName() + " : train enters the stations " + name);
        train.wait5s();
        System.out.println(train.getName() + " : train leave the stations " + name);
    }
}
