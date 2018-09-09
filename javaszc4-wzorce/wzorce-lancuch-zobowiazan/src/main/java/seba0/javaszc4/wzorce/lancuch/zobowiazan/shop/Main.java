package seba0.javaszc4.wzorce.lancuch.zobowiazan.shop;

public class Main {
    public static void main(String[] args) {
        Shop a = new Shop("A");
        Shop b = new Shop("B");
        Shop c = new Shop("C");

        a.setSuccesssor(b);
        b.setSuccesssor(c);
//        c.setSuccesssor(a);

        a.addItem(new Item("Bread"), 5);
        b.addItem(new Item("Bread"), 10);
        b.addItem(new Item("Shoes"), 2);
        c.addItem(new Item("Shoes"), 20);
        c.addItem(new Item("Car"), 1);
        ItemPurchaseRequest request = new ItemPurchaseRequest(new Item("Car"));
        a.handleRequest(request);
        System.out.println(request);
    }
}
