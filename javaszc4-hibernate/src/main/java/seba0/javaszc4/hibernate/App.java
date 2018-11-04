package seba0.javaszc4.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import seba0.javaszc4.hibernate.model.entity.Employee;
import seba0.javaszc4.hibernate.model.entity.Project;
import seba0.javaszc4.hibernate.model.service.EmployeeService;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

public class App {
    public static void main(String[] args) {

        Employee employee = new Employee("Jan Kowalski");
        employee.getProjects()
                .addAll(Arrays.asList(
                        new Project("Project A", employee),
                        new Project("Project B", employee)
                ));


        Optional<Transaction> tx = Optional.empty();

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            tx = Optional.of(session.beginTransaction());

            EmployeeService employeeService = new EmployeeService(session);
            employeeService.create(employee);
            tx.ifPresent(Transaction::commit);
            Collection<Employee> read = employeeService.read();
            for (Employee e : read) {
                System.out.println(e);
                for (Project p : e.getProjects()) {
                    System.out.println("\t" + p);
                }
            }
            tx.ifPresent(Transaction::commit);
        } catch (Throwable e) {
            e.printStackTrace();
            tx.ifPresent(Transaction::rollback);
        }
    }
}
