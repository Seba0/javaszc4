package seba0.javaszc4.zadanie.sortowanie;

import java.util.Comparator;
import java.util.Objects;

public class BubbleSort implements Sort {

    private static final Comparator COMPARATOR = new ComparableComparator();

    @Override
    public <T extends Comparable> T[] sort(T[] array) {
        Objects.requireNonNull(array);
        return (T[]) sort(array, COMPARATOR);
    }

    public <T> T[] sort(T[] array, Comparator<T> comparator) {
        Objects.requireNonNull(array);
        Objects.requireNonNull(comparator);
        for (int j = 0; j < array.length; j++) {
            boolean end = true;
            int size = array.length - j;
            for (int i = 1; i < size; i++) {
                if (comparator.compare(array[i - 1], array[i]) > 0) {
                    Sort.replace(array, i - 1, i);
                    end = false;
                }
            }
            if (end) {
                break;
            }
        }
        return array;
    }
}
