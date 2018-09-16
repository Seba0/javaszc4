package seba0.javaszc4.wzorce.mediator.taxi;

import java.util.LinkedList;
import java.util.List;

public class TaxiDispatcher implements Dispatcher {

    private final List<Taxi> taxis;

    public TaxiDispatcher() {
        this.taxis = new LinkedList<>();
    }

    @Override
    public void addTaxi(Taxi taxi) {
        taxis.add(taxi);
    }

    @Override
    public void takeOrder(String order) {
        sendOrder(order);
    }

    @Override
    public void sendOrder(String order) {
        taxis.stream()
                .filter(taxi -> taxi.getStatus() == TaxiStatus.WAITING_FOR_ORDER)
                .findFirst()
                .ifPresent(taxi -> taxi.startOrder(order));
    }

    @Override
    public void updateDriverStatus(Taxi taxi) {

    }
}
