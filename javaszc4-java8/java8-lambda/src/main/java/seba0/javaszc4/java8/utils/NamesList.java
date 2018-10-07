package seba0.javaszc4.java8.utils;

import java.util.AbstractList;
import java.util.function.IntFunction;

public class NamesList extends AbstractList<String> {

    private final IntFunction<String> nameGivenFunction;
    private final int size;

    public NamesList(IntFunction<String> nameGivenFunction) {
        this(nameGivenFunction, Integer.MAX_VALUE);
    }

    public NamesList(IntFunction<String> nameGivenFunction, int size) {
        this.nameGivenFunction = nameGivenFunction;
        this.size = size;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return nameGivenFunction.apply(index);
    }

    @Override
    public int size() {
        return size;
    }
}
