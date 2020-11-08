package com.by.petranovski.library_examples.book_library.service.service_UI;

import com.by.petranovski.library_examples.book_library.service.BookDatabase;
import com.by.petranovski.library_examples.book_library.service.UIAction;

import java.util.Scanner;

public class DeleteByIdUIAction implements UIAction {

    private BookDatabase bookDatabase;

    public DeleteByIdUIAction (BookDatabase bookDatabase) {
        this.bookDatabase = bookDatabase;
    }
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter please book's id:");
        Long id = scanner.nextLong();

        if (bookDatabase.delete(id)) {
            System.out.println("Book was deleted.");
        } else {
            System.out.println("Cant find book with such ID.");
        }
    }

    @Override
    public String getAction() {
        return "Delete book on id";
    }
}
