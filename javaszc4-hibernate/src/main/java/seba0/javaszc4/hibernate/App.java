package seba0.javaszc4.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        Optional<Transaction> tx = Optional.empty();

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            tx = Optional.of(session.beginTransaction());
/**
 List<Employee> emploiers = getAll(session, Employee.class);
 if (emploiers.isEmpty()) {
 List<Department> departments = getAll(session, Department.class);
 if (departments.isEmpty()) {
 for (int i = 0; i < 10; i++) {
 Department department = new Department();
 department.setName("Name " + i);
 session.save(department);
 departments.add(department);
 }
 }
 for (int i = 0; i < departments.size(); i++) {
 Employee employee = new Employee();
 employee.setFirstName("First Name " + i);
 employee.setLastName("Last Name " + i);
 employee.setPosition("None of " + i);
 employee.setDepartment(departments.get(i));
 for (int k = 0; k < 10; k++) {
 Project project = new Project();
 project.setName("Name " + i + "." + k);
 employee.getProjects().add(project);
 session.save(project);
 }
 session.save(employee);
 emploiers.add(employee);
 }
 }
 **/
            tx.ifPresent(Transaction::commit);
        } catch (Throwable e) {
            e.printStackTrace();
            tx.ifPresent(Transaction::rollback);
        }
    }

    private static <T extends Serializable> List<T> getAll(Session session, Class<T> entityClass) {
        CriteriaBuilder cbuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = cbuilder.createQuery(entityClass);
        Root<T> root = query.from(entityClass);
        return session
                .createQuery(query.select(root))
                .getResultList();
    }
}
