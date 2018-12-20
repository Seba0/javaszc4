package seba0.javaszc4.spring.frontend.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import java.util.Objects;
import java.util.function.Function;

class ValidateUnit<T> {

    private final T object;
    private final Errors errors;
    private final String formName;

    ValidateUnit(T object, Errors errors, String formName) {
        this.object = object;
        this.errors = errors;
        this.formName = formName;
    }

    void size(Function<T, String> sizeFunc, String field, int min, int max) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, field, "NotEmpty");
        String value = sizeFunc.apply(object);
        if (value == null || value.length() < min || value.length() > max) {
            errors.rejectValue(field, "Size." + formName + "." + field);
        }
    }

    <R> void equals(Function<T, R> funcValue, Function<T, R> funcExpected, String field) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, field, "NotEmpty");
        Object value = funcValue.apply(object);
        Object expected = funcExpected.apply(object);
        if (!Objects.equals(value, expected)) {
            errors.rejectValue(field, "Equals." + formName + "." + field);
        }
    }
}
