package seba0.javaszc4.solid.interfaces.segregation.restaurant;

import java.math.BigDecimal;
import java.util.Map;

public class CafeOrder implements Order {

    @Override
    public void accept(Map<Dish, Integer> orderedDishes) {

    }

    @Override
    public void deliver(Address address) {

    }

    @Override
    public void pay(BigDecimal payment, PaymentType type) {

    }
}
