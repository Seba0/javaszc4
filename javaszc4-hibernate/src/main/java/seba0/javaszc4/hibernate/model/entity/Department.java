package seba0.javaszc4.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Department  implements Serializable {

    private static final long serialVersionUID = 12L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 70, nullable = false, unique = true)
    private String name;

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

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
