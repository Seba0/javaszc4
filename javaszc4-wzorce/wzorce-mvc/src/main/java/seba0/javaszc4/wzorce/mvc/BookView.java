package seba0.javaszc4.wzorce.mvc;

import java.util.Scanner;

public class BookView {
    private Scanner scanner = new Scanner(System.in);

    public String getBookName() {
        System.out.println("Podaj nazwę książki: ");
        return scanner.next();

    }

    public void showBook(String bookName) {
        System.out.println("Książka: " + bookName);
    }
}
