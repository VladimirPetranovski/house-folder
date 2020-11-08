package com.by.petranovski.library_examples.book_library.service.service_UI;

import com.by.petranovski.library_examples.book_library.bean.Book;
import com.by.petranovski.library_examples.book_library.service.BookDatabase;
import com.by.petranovski.library_examples.book_library.service.UIAction;

import java.util.Scanner;

public class SaveBookUIAction implements UIAction {

    private BookDatabase bookDatabase;

    public SaveBookUIAction (BookDatabase bookDatabase) {
        this.bookDatabase = bookDatabase;
    }


    @Override
    public void execute() {
        System.out.println("Enter please book's name:");
        Scanner scanner = new Scanner(System.in);
        String nameSearch = scanner.nextLine();
        System.out.println("Enter please book's author:");
        String nameAuthorSearch = scanner.nextLine();
        System.out.println("Enter please book's year issue:");
        String yearIssue = scanner.nextLine();

        Book book = new Book(nameSearch, nameAuthorSearch, yearIssue);
        bookDatabase.save(book);
    }

    @Override
    public String getAction() {
        return "Save book";
    }
}
