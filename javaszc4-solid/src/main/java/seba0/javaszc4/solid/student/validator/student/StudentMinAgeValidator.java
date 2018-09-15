package seba0.javaszc4.solid.student.validator.student;

import seba0.javaszc4.solid.student.Student;
import seba0.javaszc4.solid.student.validator.Validator;

public class StudentMinAgeValidator extends StudentValidator {

    private final int minAge;

    public StudentMinAgeValidator(int minAge, Validator<Student> suppilor) {
        super(suppilor);
        this.minAge = minAge;
    }

    @Override
    public boolean isValid(Student student) {
        if (student == null) {
            return false;
        }
        return student.getAge() >= minAge;
    }
}
