package seba0.javaszc4.wzorce.mediator.taxi;

public interface Dispatcher {
    void takeOrder(String order);

    void sendOrder(String order);

    void updateDriverStatus(Taxi taxi);

    void addTaxi(Taxi taxi);
}
