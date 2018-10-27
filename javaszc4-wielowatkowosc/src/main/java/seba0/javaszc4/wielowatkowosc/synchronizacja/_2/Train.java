package seba0.javaszc4.wielowatkowosc.synchronizacja._2;

public class Train extends Thread {

    private final Station station;

    public Train(String name, Station station) {
        setName(name);
        this.station = station;
    }

    @Override
    public void run() {
        wait5s();
        System.out.println(getName() + " : train arrives");
        station.atTheStation(this);
        System.out.println(getName() + " : train went on tour");
        wait5s();
    }

    public void wait5s() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
