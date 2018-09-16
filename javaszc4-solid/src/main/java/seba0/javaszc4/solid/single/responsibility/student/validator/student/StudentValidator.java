package seba0.javaszc4.solid.single.responsibility.student.validator.student;

import seba0.javaszc4.solid.single.responsibility.student.Student;
import seba0.javaszc4.solid.single.responsibility.student.validator.Validator;
import seba0.javaszc4.solid.single.responsibility.student.validator.ValidatorChain;

public abstract class StudentValidator extends ValidatorChain<Student> {

//    private final static StudentValidator vali;vali

    public StudentValidator(Validator<Student> suppilor) {
        super(suppilor);
    }

//    public static boolean isValid(Student student) {
//
//    }
}
