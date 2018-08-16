package seba0.javaszc4.malafirma.server.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Employee extends Person {

    @ManyToOne(optional = false)
    private Position position;

    @ManyToOne(optional = false)
    private Section section;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(position, employee.position) &&
                Objects.equals(section, employee.section);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), position, section);
    }
}

