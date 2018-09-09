package seba0.javaszc4.wzorce.pizza;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new PizzaMargeritha();
        pizza = new CheesePizza(pizza);
        pizza = new HamPizza(pizza);
        pizza.makePizza();
    }
}
