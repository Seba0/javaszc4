package seba0.javaszc4.solid.student.validator.student;

import seba0.javaszc4.solid.student.Student;
import seba0.javaszc4.solid.student.validator.Validator;
import seba0.javaszc4.solid.student.validator.ValidatorChain;

public abstract class StudentValidator extends ValidatorChain<Student> {
    public StudentValidator(Validator<Student> suppilor) {
        super(suppilor);
    }
}
