package seba0.javaszc4.java8.functional.interfaces.supplier._2;

import lombok.AllArgsConstructor;
import lombok.Data;
import seba0.javaszc4.java8.utils.NamesList;

import java.util.List;

@Data
@AllArgsConstructor
public class Book {
    public static final List<String> NAMES = new NamesList(i -> "Book Nr " + i, 100);

    private String name;
}
