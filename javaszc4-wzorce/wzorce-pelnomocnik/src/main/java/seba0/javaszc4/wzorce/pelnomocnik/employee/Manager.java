package seba0.javaszc4.wzorce.pelnomocnik.employee;

public class Manager implements Employee {
    @Override
    public void generateTimeReport() {
        System.out.println("Manager.generateTimeReport");
    }

    @Override
    public boolean hasPermission() {
        System.out.println("Manager.hasPermission");
        return true;
    }
}
