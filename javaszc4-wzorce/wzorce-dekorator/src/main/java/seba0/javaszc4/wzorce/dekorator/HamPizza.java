package seba0.javaszc4.wzorce.dekorator;

public class HamPizza extends PizzaDecorator {

    public HamPizza(Pizza pizza) {
        super(pizza);
    }

    @Override
    protected void decoratePizza() {
        System.out.println("More Ham...");
    }
}
