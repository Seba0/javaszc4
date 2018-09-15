package seba0.javaszc4.wzorce.zadania.kompozyt;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/**
 * Organization IT class
 *
 * @author sebastian
 */
public class OrganizationIT {

    private final String name;
    private final Manager mainManager;

    /**
     * Constructor
     *
     * @param name name of Organization
     * @param manager main manager of Organization
     */
    public OrganizationIT(String name, Manager manager) {
        this.name = Objects.requireNonNull(name);
        this.mainManager = Objects.requireNonNull(manager);
    }

    /**
     * Get name of Organization
     *
     * @return name of Organization
     */
    public String getName() {
        return name;
    }

    /**
     * Get main manager of Organization
     *
     * @return main manager
     */
    public Manager getMainManager() {
        return mainManager;
    }

    /**
     * Find Employee by name
     *
     * @param name of searching Employee
     * @return Employee if faind
     */
    public Optional<Employee> findEmployeer(String name) {
        if (Objects.equals(mainManager.getName(), name)) {
            return Optional.of(mainManager);
        }
        return mainManager.findEmployeer(name);
    }

    /**
     * Get all Employees
     *
     * @return all Employees
     */
    public Set<Employee> getEmployes() {
        Set<Employee> employees = new HashSet<>();
        employees.add(mainManager);
        employees.addAll(mainManager.getSubEmployes());
        return employees;
    }
}
