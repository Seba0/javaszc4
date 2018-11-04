package seba0.javaszc4.hibernate.model.service;

import org.hibernate.Session;
import seba0.javaszc4.hibernate.model.entity.Employee;

public class EmployeeService extends EntityService<Employee> {

    public EmployeeService(Session session) {
        super(session, Employee.class);
    }
}
