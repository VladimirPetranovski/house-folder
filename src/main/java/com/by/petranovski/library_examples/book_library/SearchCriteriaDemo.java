package com.by.petranovski.library_examples.book_library;

import com.by.petranovski.library_examples.book_library.bean.Book;
import com.by.petranovski.library_examples.book_library.service.SearchCriteria;
import com.by.petranovski.library_examples.book_library.service.service_bookDatabaseImpl.BookDatabaseImpl;
import com.by.petranovski.library_examples.book_library.service.service_search.*;

public class SearchCriteriaDemo {
    public static void main(String[] args) {
        Book book = new Book("Zveroboi", "Kuper", "1890");

        SearchCriteria titleSearchCriteria = new TitleSearchCriteria("Zveroboi");
        SearchCriteria authorSearchCriteria = new AuthorSearchCriteria("Kuper");
        SearchCriteria yearOfIssue = new YearOfIssueSearchCriteria("1890");

        SearchCriteria searchCriteria1 = new AndSearchCriteria(titleSearchCriteria, authorSearchCriteria);
        SearchCriteria searchCriteria2 = new AndSearchCriteria(authorSearchCriteria, yearOfIssue);
        SearchCriteria searchCriteria3 = new OrSearchCriteria(authorSearchCriteria, yearOfIssue);
        SearchCriteria searchCriteria4 = new OrSearchCriteria(authorSearchCriteria, titleSearchCriteria);

        System.out.println(searchCriteria1.match(book));
        System.out.println(searchCriteria2.match(book));
        System.out.println(searchCriteria3.match(book));
        System.out.println(searchCriteria4.match(book));

        BookDatabaseImpl bookDatabase = new BookDatabaseImpl();
        bookDatabase.save(book);
        System.out.println(bookDatabase.find(searchCriteria1));

        // super_task_1_paging
        for (int i = 0; i < 30; i++) {
            String title = "Pushkin";
            String author = Integer.toString(i);
            String yearIssue = String.valueOf(1980 + i);
            Book book1 = new Book(title, author, yearIssue);
            bookDatabase.save(book1);
        }
        SearchCriteria searchTitle = new TitleSearchCriteria("Pushkin");
        System.out.println(bookDatabase.find(searchTitle, 1, 10));
        System.out.println(bookDatabase.find(searchTitle, 11, 20));
    }
}
