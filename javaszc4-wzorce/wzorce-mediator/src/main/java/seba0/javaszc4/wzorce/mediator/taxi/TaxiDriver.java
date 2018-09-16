package seba0.javaszc4.wzorce.mediator.taxi;

public class TaxiDriver extends Taxi {
    public TaxiDriver(Dispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void startOrder(String order) {
        status = TaxiStatus.DURING_ORDER;
    }

    @Override
    public void stopOrder() {
        status = TaxiStatus.WAITING_FOR_ORDER;
        dispatcher.updateDriverStatus(this);
    }
}
