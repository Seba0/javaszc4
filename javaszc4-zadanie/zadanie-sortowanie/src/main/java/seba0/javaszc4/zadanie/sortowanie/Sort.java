package seba0.javaszc4.zadanie.sortowanie;

import java.util.Comparator;

public interface Sort {

    <T extends Comparable> T[] sort(T[] array);

    <T> T[] sort(T[] array, Comparator<T> comparator);

    static <T> T[] replace(T[] array, int i1, int i2) {
        T tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
        return array;
    }
}
