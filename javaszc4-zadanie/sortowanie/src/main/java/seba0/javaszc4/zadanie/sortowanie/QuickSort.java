package seba0.javaszc4.zadanie.sortowanie;

import java.util.Comparator;
import java.util.Objects;

public class QuickSort implements Sort {

    private static final Comparator COMPARATOR = new ComparableComparator();

    @Override
    public <T extends Comparable> T[] sort(T[] array) {
        Objects.requireNonNull(array);
        return (T[]) sort(array, COMPARATOR);
    }

    private <T> T[] quick(T[] array, int left, int right, Comparator<T> comparator) {
        if (left >= right) {
            return array;
        }
        T pivot = array[right];
        int border = left - 1;
        int index = left;
        while (index != right) {
            T item = array[index];
            int compare = comparator.compare(item, pivot);
            if (compare < 0) {
                border++;
                if (index != border) {
                    Sort.replace(array, index, border);
                }
            }
            index++;
        }
        border++;
        if (border != right) {
            Sort.replace(array, index, border);
        }
        quick(array, left, border - 1, comparator);
        quick(array, border + 1, right, comparator);
        return array;
    }

    public <T> T[] sort(T[] array, Comparator<T> comparator) {
        Objects.requireNonNull(array);
        Objects.requireNonNull(comparator);

        quick(array, 0, array.length - 1, comparator);

        return array;
    }
}
