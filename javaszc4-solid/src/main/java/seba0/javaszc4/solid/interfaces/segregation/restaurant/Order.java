package seba0.javaszc4.solid.interfaces.segregation.restaurant;

import java.math.BigDecimal;
import java.util.Map;

public interface Order {
    void accept(Map<Dish, Integer> orderedDishes, Address address, PaymentType type);

    void make();

    void deliver();

    void pay(BigDecimal payment);
}
