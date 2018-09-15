package seba0.javaszc4.solid.student.validator.student;

import seba0.javaszc4.solid.student.Student;
import seba0.javaszc4.solid.student.validator.Validator;

public class StudentMaxAgeValidator extends StudentValidator {

    private final int maxAge;

    public StudentMaxAgeValidator(int maxAge, Validator<Student> suppilor) {
        super(suppilor);
        this.maxAge = maxAge;
    }

    @Override
    public boolean isValid(Student student) {
        if (student == null) {
            return false;
        }
        return student.getAge() <= maxAge;
    }
}
