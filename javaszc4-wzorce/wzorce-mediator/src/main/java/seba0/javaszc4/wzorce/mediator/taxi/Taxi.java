package seba0.javaszc4.wzorce.mediator.taxi;

public abstract class Taxi {

    protected TaxiStatus status;
    protected final Dispatcher dispatcher;

    public Taxi(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
        this.status = TaxiStatus.WAITING_FOR_ORDER;
    }

    public TaxiStatus getStatus() {
        return status;
    }

    public abstract void startOrder(String order);

    public abstract void stopOrder();
}
