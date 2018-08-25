package seba0.javaszc4.zadanie.sortowanie;

import java.util.Comparator;
import java.util.Objects;

public class HeapSort implements Sort {

    private static final Comparator COMPARATOR = new ComparableComparator();

    private static int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private static int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private static int getPatentIndex(int childIndex) {
        int parentIndex = childIndex % 2 == 0
                ? childIndex - 2
                : childIndex - 1;
        return parentIndex / 2;
    }

    private <T> int replace(int parentIndex, T[] array, int last, Comparator<T> comparator) {
        int childIndex = getLeftChildIndex(parentIndex);

        if (childIndex >= last) {
            return -1;
        }

        T childValue = array[childIndex];
        int rightIndex = getRightChildIndex(parentIndex);

        if (rightIndex < last) {
            T rightValue = array[rightIndex];

            if (comparator.compare(childValue, rightValue) < 0) {
                childIndex = rightIndex;
                childValue = rightValue;
            }
        }

        T parentValue = array[parentIndex];

        if (comparator.compare(childValue, parentValue) > 0) {
            array[parentIndex] = childValue;
            array[childIndex] = parentValue;
            return childIndex;
        }
        return -1;
    }

    private static <T> boolean revertReplace(int index, T[] array, Comparator<T> comparator) {
        if (index > 0) {
            int parentIndex = getPatentIndex(index);
            T value = array[index];
            T parent = array[parentIndex];
            if (comparator.compare(value, parent) > 0) {
                array[parentIndex] = value;
                array[index] = parent;
                revertReplace(parentIndex, array, comparator);
                return true;
            }
        }
        return false;
    }

    @Override
    public <T extends Comparable> T[] sort(T[] array) {
        Objects.requireNonNull(array);
        return (T[]) sort(array, COMPARATOR);
    }

    @Override
    public <T> T[] sort(T[] array, Comparator<T> comparator) {
        int lastIndex = array.length;
        for (int i = 0; i < lastIndex; i++) {
            revertReplace(i, array, comparator);
        }
        while (--lastIndex >= 0) {
            T value = array[lastIndex];
            array[lastIndex] = array[0];
            array[0] = value;

            boolean retry;
            do {
                retry = false;
                int index = 0;
                while ((index = replace(index, array, lastIndex, comparator)) >= 0) {
                    retry = true;
                }
            } while (retry);
        }
        return array;
    }
}
