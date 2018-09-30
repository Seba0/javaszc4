package seba0.javaszc4.wzorce.pelnomocnik.employee;

import java.util.Objects;

public class ProxyEmployee implements Employee {
    private final Employee employee;

    public ProxyEmployee(Employee employee) {
        this.employee = Objects.requireNonNull(employee);
    }

    @Override
    public void generateTimeReport() {
        System.out.println("ProxyEmployee.generateTimeReport");
        if (!employee.hasPermission()) {
            throw new SecurityException("No permissions!!!");
        }
        employee.generateTimeReport();
    }

    @Override
    public boolean hasPermission() {
        System.out.println("ProxyEmployee.hasPermission");
        return employee.hasPermission();
    }
}
