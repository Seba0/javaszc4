package seba0.javaszc4.java8.lambda._5;

import java.util.List;
import java.util.function.Consumer;

public class ListPresenter {
    public static <T> void showList(List<T> list, Consumer<T> consumer) {
        list.forEach(consumer);
    }
}
