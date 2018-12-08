package seba0.javaszc4.wzorce.mvc;

public class BookController {

    private final BookRepository repository;
    private final BookView view;

    public BookController(BookRepository repository, BookView view) {
        this.repository = repository;
        this.view = view;
    }

    public void showBooks() {
        for (Book book : repository.read()) {
            view.showBook(book.getName());
        }
    }


    public void addBook() {
        String bookName = view.getBookName();
        Book book = new Book();
        book.setName(bookName);
        repository.create(book);
    }
}
