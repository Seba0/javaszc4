package seba0.javaszc4.wzorce.mediator.taxi;

public class Demo {
    public static void main(String[] args) {
        Dispatcher dispatcher = new TaxiDispatcher();

        Taxi taxi1 = new TaxiDriver(dispatcher);
        Taxi taxi2 = new TaxiDriver(dispatcher);
        Taxi taxi3 = new TaxiDriver(dispatcher);

        dispatcher.addTaxi(taxi1);
        dispatcher.addTaxi(taxi2);
        dispatcher.addTaxi(taxi3);

        dispatcher.takeOrder("Order 1");
    }
}
