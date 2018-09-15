package seba0.javaszc4.wzorce.zadania.kompozyt;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Manager class extends Employee
 *
 * @author sebastian
 */
public class Manager extends Employee {

    private final Set<Employee> employees = new HashSet<>();

    /**
     * Constructor
     *
     * @param name name of Manager
     */
    public Manager(String name) {
        super(name);
    }

    /**
     * Get Employeers under this Manager
     *
     * @return Set of Employeers
     */
    public Set<Employee> getEmployees() {
        return employees;
    }

    /**
     * Get Managers under this Manager
     *
     * @return Set of Managers
     */
    public Set<Manager> getMenagers() {
        return employees.parallelStream()
                .filter(employee -> (employee instanceof Manager))
                .map(employee -> (Manager) employee)
                .collect(Collectors.toSet());
    }

    /**
     * Get Developers under this Manager
     *
     * @return Set of Developers
     */
    public Set<Developer> getDevelopers() {
        return employees.parallelStream()
                .filter(employee -> (employee instanceof Developer))
                .map(employee -> (Developer) employee)
                .collect(Collectors.toSet());
    }

    /**
     * Find Employee by name
     *
     * @param name of searching Employee
     * @return Employee if faind
     */
    public Optional<Employee> findEmployeer(String name) {
        for (Employee employee : employees) {
            if (Objects.equals(employee.getName(), name)) {
                return Optional.of(employee);
            } else if (employee instanceof Manager) {
                Manager manager = (Manager) employee;
                Optional<Employee> find = manager.findEmployeer(name);
                if (find.isPresent()) {
                    return find;
                }
            }
        }
        return Optional.empty();
    }

    private static Stream<Employee> getSubEmployesStream(Manager manager) {
        return manager.getSubEmployes().parallelStream();
    }

    /**
     * Get Employeers under this Manager and sub Menagers
     *
     * @return Set of all Employeers
     */
    public Set<Employee> getSubEmployes() {
        Set<Employee> subEmployees = new HashSet<>();
        subEmployees.addAll(employees);
        subEmployees.addAll(employees.parallelStream()
                .filter(employee -> (employee instanceof Manager))
                .map(employee -> (Manager) employee)
                .flatMap(Manager::getSubEmployesStream)
                .collect(Collectors.toSet()));
        return subEmployees;
    }
}
