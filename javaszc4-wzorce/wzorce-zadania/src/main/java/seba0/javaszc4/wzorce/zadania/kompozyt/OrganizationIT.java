package seba0.javaszc4.wzorce.zadania.kompozyt;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/**
 *
 * @author sebastian
 */
public class OrganizationIT {

    private final String name;
    private final Manager mainManager;

    public OrganizationIT(String name, Manager manager) {
        this.name = Objects.requireNonNull(name);
        this.mainManager = Objects.requireNonNull(manager);
    }

    public String getName() {
        return name;
    }

    public Manager getMainManager() {
        return mainManager;
    }

    public Optional<Manager> getManager(String name) {
        if (Objects.equals(mainManager.getName(), name)) {
            return Optional.of(mainManager);
        }
        return mainManager.findManager(name);
    }

    public Optional<Developer> getDeveloper(String name) {
        return mainManager.findDeveloper(name);
    }

    public Set<Employee> getEmployes() {
        Set<Employee> employees = new HashSet<>();
        employees.add(mainManager);
        employees.addAll(mainManager.getSubEmployes());
        return employees;
    }
}
