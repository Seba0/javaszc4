package seba0.javaszc4.hibernate.model.entity;

import javax.persistence.*;

@Entity
public class Project {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    private Employee employee;

    public Project() {
    }

    public Project(String name, Employee employee) {
        this.name = name;
        this.employee = employee;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employee=" + employee.getId() +
                '}';
    }
}
