package seba0.javaszc4.solid.single.responsibility.student.validator;

public abstract class ValidatorChain<T> implements Validator<T> {

    private final Validator<T> suppilor;

    public ValidatorChain(Validator<T> suppilor) {
        this.suppilor = suppilor;
    }

    public final boolean validate(T value) {
        if (!isValid(value)) {
            return false;
        } else if (suppilor == null) {
            return true;
        } else if (suppilor instanceof ValidatorChain) {
            ValidatorChain chain = (ValidatorChain) suppilor;
            return chain.validate(value);
        }
        return suppilor.isValid(value);
    }
}
