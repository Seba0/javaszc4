package seba0.javaszc4.malafirma.server.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Section)) return false;
        Section section = (Section) o;
        return Objects.equals(id, section.id) &&
                Objects.equals(name, section.name) &&
                Objects.equals(description, section.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
