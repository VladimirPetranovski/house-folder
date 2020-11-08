package com.by.petranovski.library_examples.book_library.service.service_UI;

import com.by.petranovski.library_examples.book_library.bean.Book;
import com.by.petranovski.library_examples.book_library.service.BookDatabase;
import com.by.petranovski.library_examples.book_library.service.UIAction;

import java.util.Optional;
import java.util.Scanner;

public class FindByIdUIAction implements UIAction {

    private BookDatabase bookDatabase;

    public FindByIdUIAction (BookDatabase bookDatabase) {
        this.bookDatabase = bookDatabase;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter please book's id for search:");
        Long id = scanner.nextLong();

        Optional<Book> bookOpt = bookDatabase.findById(id);
        if (bookOpt.isPresent()) {
            System.out.println("You looked for: " + bookOpt.get());
        } else {
            System.out.println("There is no books with such ID.");
        }
    }

    @Override
    public String getAction() {
        return "Find book on Id";
    }
}
