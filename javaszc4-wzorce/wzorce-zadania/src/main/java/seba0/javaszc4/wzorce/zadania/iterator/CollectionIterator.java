package seba0.javaszc4.wzorce.zadania.iterator;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Bi-directional iterator for arrays
 *
 * @author sebastian
 * @param <E> type of element in array
 */
public class CollectionIterator<E> implements Iterator<E> {

    private int cursor = -1;
    private final E[] array;

    /**
     * Constructor
     *
     * @param array array of elements for iteration
     */
    public CollectionIterator(E[] array) {
        Objects.requireNonNull(array);
        this.array = Arrays.copyOf(array, array.length);
    }

    /**
     * Constructor
     *
     * @param collection collection of elements for iteration
     */
    public CollectionIterator(Collection<E> collection) {
        Objects.requireNonNull(collection);
        this.array = (E[]) collection.toArray();
    }

    /**
     * Check next cursor position
     *
     * @return true if next cursor position ponting on valid value otherwise
     * false
     */
    @Override
    public boolean hasNext() {
        int nextCursor = nextCursor();
        return inRange(nextCursor);
    }

    /**
     * Move cursor to next element and return it
     *
     * @return next element in array
     * @throws NoSuchElementException if next cursor position is incorrect
     */
    @Override
    public E next() {
        int nextCursor = nextCursor();
        if (!inRange(nextCursor)) {
            throw new NoSuchElementException();
        }
        cursor = nextCursor;
        return array[nextCursor];
    }

    /**
     * Check previous cursor position
     *
     * @return true if previous cursor position ponting on valid value otherwise
     * false
     */
    public boolean hasPrevious() {
        int previousCursor = previousCursor();
        return inRange(previousCursor);
    }

    /**
     * Move cursor to previous element and return it
     *
     * @return previous element in array
     * @throws NoSuchElementException if previous cursor position is incorrect
     */
    public E previous() {
        int previousCursor = previousCursor();
        if (!inRange(previousCursor)) {
            throw new NoSuchElementException();
        }
        cursor = previousCursor;
        return array[previousCursor];
    }

    private int nextCursor() {
        return cursor + 1;
    }

    private int previousCursor() {
        return cursor - 1;
    }

    private boolean inRange(int previousCursor) {
        return previousCursor >= 0 && previousCursor < array.length;
    }
}
