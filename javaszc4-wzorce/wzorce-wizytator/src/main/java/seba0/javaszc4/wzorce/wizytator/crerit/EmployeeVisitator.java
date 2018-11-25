package seba0.javaszc4.wzorce.wizytator.crerit;

@FunctionalInterface
public interface EmployeeVisitator {
    boolean visit(Employee employee);
}
