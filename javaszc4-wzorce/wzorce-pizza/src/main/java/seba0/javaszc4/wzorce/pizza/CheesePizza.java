package seba0.javaszc4.wzorce.pizza;

public class CheesePizza extends PizzaDecorator {
    public CheesePizza(Pizza pizza) {
        super(pizza);
    }

    @Override
    protected void decoratePizza() {
        System.out.println("More cheese...");
    }
}
