package seba0.javaszc4.solid.single.responsibility.student.validator.student;

import seba0.javaszc4.solid.single.responsibility.student.Student;
import seba0.javaszc4.solid.single.responsibility.student.validator.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentEmailValidator extends StudentValidator {

    private final Pattern patter;
    private static final String PATTERN = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

    public StudentEmailValidator(Validator<Student> suppilor) {
        super(suppilor);
        this.patter = Pattern.compile(PATTERN, Pattern.CASE_INSENSITIVE);
    }

    @Override
    public boolean isValid(Student student) {
        if (student == null) {
            return false;
        }
        String email = student.getEmail();
        if (email == null) {
            return false;
        }
        Matcher matcher = patter.matcher(email);
        return matcher.matches();
    }
}
