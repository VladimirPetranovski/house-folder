package com.by.petranovski.library_examples.book_library.service.service_UI;

import com.by.petranovski.library_examples.book_library.bean.Book;
import com.by.petranovski.library_examples.book_library.service.BookDatabase;
import com.by.petranovski.library_examples.book_library.service.UIAction;

import java.util.List;
import java.util.Scanner;

public class FindByAuthorUIAction implements UIAction {

    private BookDatabase bookDatabase;

    public FindByAuthorUIAction(BookDatabase bookDatabase) {
        this.bookDatabase = bookDatabase;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter please book's author for search:");
        String nameAuthor = scanner.nextLine();

        List<Book> bookOpt = bookDatabase.findByAuthor(nameAuthor);

        if (!bookOpt.isEmpty()) {
            System.out.println("You looked for: " + bookOpt);
        } else {
            System.out.println("There is no books with such author.");
        }
    }

    @Override
    public String getAction() {
        return "Find book on author";
    }
}
