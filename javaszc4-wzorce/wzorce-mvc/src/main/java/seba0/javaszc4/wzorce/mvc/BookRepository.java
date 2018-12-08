package seba0.javaszc4.wzorce.mvc;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private final List<Book> books = new ArrayList<>();

    boolean create(Book book) {
        return books.add(book);
    }

    List<Book> read() {
        return new ArrayList<>(books);
    }

}
