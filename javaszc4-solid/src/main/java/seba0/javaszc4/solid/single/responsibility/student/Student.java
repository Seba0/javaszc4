package seba0.javaszc4.solid.single.responsibility.student;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Student {
    private final int age;
    private String name;
    private String email;
    private Map<String, Integer> scores;

    public Student(int age, String name, String email) {
        this.age = age;
        this.name = name;
        this.email = email;
        this.scores = new HashMap<>();
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, Integer> getScores() {
        return scores;
    }

    public void setScores(Map<String, Integer> scores) {
        this.scores = scores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(email);
    }
}
