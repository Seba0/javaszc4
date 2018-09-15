package seba0.javaszc4.wzorce.zadania.kompozyt;

import java.util.Objects;

/**
 * Employee class
 *
 * @author sebastian
 */
public abstract class Employee {

    private String name;
    private int payment;

    /**
     * Constructor
     *
     * @param name name of Employee
     */
    public Employee(String name) {
        this.name = Objects.requireNonNull(name);
    }

    /**
     * Get name of Employee
     *
     * @return name of Employee
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of Employee
     *
     * @param name name of Employee
     */
    public void setName(String name) {
        this.name = Objects.requireNonNull(name);
    }

    /**
     * Get payment for Employee
     *
     * @return payment for Employee
     */
    public int getPayment() {
        return payment;
    }

    /**
     * Set payment for Employee
     *
     * @param payment payment for Employee
     */
    public void setPayment(int payment) {
        this.payment = payment;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + this.payment;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (this.payment != other.payment) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", payment=" + payment + '}';
    }
}
