package seba0.javaszc4.wzorce.mvc;

public class Main {
    public static void main(String[] args) {
        BookView bookView = new BookView();

        BookRepository bookRepository = new BookRepository();
        BookController bookController = new BookController(bookRepository, bookView);
        bookController.addBook();
        bookController.showBooks();
    }
}
