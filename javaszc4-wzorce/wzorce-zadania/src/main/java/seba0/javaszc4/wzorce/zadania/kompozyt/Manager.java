package seba0.javaszc4.wzorce.zadania.kompozyt;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/**
 *
 * @author sebastian
 */
public class Manager extends Employee {

    private final Set<Manager> managers = new HashSet<>();
    private final Set<Developer> developers = new HashSet<>();

    public Set<Manager> getManagers() {
        return managers;
    }

    public Optional<Manager> findManager(String name) {
        for (Manager manager : managers) {
            if (Objects.equals(manager.getName(), name)) {
                return Optional.of(manager);
            }
            Optional<Manager> find = manager.findManager(name);
            if (find.isPresent()) {
                return find;
            }
        }
        return Optional.empty();
    }

    public Set<Developer> getDevelopers() {
        return developers;
    }

    public Optional<Developer> findDeveloper(String name) {
        for (Developer developer : developers) {
            if (Objects.equals(developer.getName(), name)) {
                return Optional.of(developer);
            }
        }
        for (Manager manager : managers) {
            Optional<Developer> find = manager.findDeveloper(name);
            if (find.isPresent()) {
                return find;
            }
        }
        return Optional.empty();
    }

    public Set<Employee> getSubEmployes() {
        Set<Employee> employees = new HashSet<>();
        employees.addAll(developers);
        managers.stream()
                .forEach(manager -> {
                    employees.add(manager);
                    employees.addAll(manager.getSubEmployes());
                });
        return employees;
    }
}
