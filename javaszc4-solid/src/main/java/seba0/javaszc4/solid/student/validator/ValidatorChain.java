package seba0.javaszc4.solid.student.validator;

public abstract class ValidatorChain<T> implements Validator<T> {

    private final Validator<T> suppilor;

    public ValidatorChain(Validator<T> suppilor) {
        this.suppilor = suppilor;
    }

    public final boolean validate(T value) {
        if (isValid(value)) {
            if (suppilor instanceof ValidatorChain) {
                ValidatorChain chain = (ValidatorChain) suppilor;
                return chain.validate(value);
            }
            return true;
        }
        return false;
    }
}
