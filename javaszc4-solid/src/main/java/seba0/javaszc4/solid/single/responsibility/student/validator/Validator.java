package seba0.javaszc4.solid.single.responsibility.student.validator;

public interface Validator<T> {

    boolean isValid(T value);
}
