package seba0.javaszc4.zadanie.sortowanie;

import java.util.Comparator;

public class ComparableComparator implements Comparator<Comparable> {

    @Override
    public int compare(Comparable o1, Comparable o2) {
        if (o1 == null && o2 == null) {
            return 0;
        } else if (o1 == null) {
            return -1;
        } else if (o2 == null) {
            return 1;
        }
        return o1.compareTo(o2);
    }
}
