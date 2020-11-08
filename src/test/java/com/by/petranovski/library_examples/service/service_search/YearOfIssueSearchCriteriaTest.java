package com.by.petranovski.library_examples.service.service_search;

import com.by.petranovski.library_examples.book_library.bean.Book;
import com.by.petranovski.library_examples.book_library.service.service_search.YearOfIssueSearchCriteria;
import junit.framework.TestCase;

public class YearOfIssueSearchCriteriaTest extends TestCase {

    private final YearOfIssueSearchCriteria test = new YearOfIssueSearchCriteria("2000");

    private final Book book2 = new Book("An black ear", "Pushkin", "1799");
    private final Book book5 = new Book("Five", "authorFive", "2000");

    public void testMatchTrue() {
        assertTrue(test.match(book5));
    }

    public void testMatchFalse() {
        assertFalse(test.match(book2));
    }
}