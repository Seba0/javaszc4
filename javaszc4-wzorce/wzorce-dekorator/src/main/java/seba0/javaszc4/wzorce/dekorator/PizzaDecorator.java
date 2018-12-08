package seba0.javaszc4.wzorce.dekorator;

public abstract class PizzaDecorator implements Pizza {
    private final Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    public final void makePizza() {
        this.pizza.makePizza();
        decoratePizza();
    }

    abstract protected void decoratePizza();
}
