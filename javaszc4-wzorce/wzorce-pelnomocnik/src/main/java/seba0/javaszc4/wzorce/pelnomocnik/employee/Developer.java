package seba0.javaszc4.wzorce.pelnomocnik.employee;

public class Developer implements Employee {
    @Override
    public void generateTimeReport() {
        System.out.println("Developer.generateTimeReport");
    }

    @Override
    public boolean hasPermission() {
        System.out.println("Developer.hasPermission");
        return false;
    }
}
