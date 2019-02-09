package seba0.javaszc4.wzorce.obiekt.rozszerzenia;

import java.util.List;
import java.util.Map;

public class Extensions {

    public static <K, V> V getItem(Map<K, V> obj, K key, V ifNotContain) {
        return obj.getOrDefault(key, ifNotContain);
    }

    public static <E> E getItem(List<E> obj, int index, E ifNull) {
        try {
            return obj.get(index);
        } catch (IndexOutOfBoundsException e) {
            return ifNull;
        }
    }
}
