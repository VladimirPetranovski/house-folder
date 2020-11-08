package com.by.petranovski.library_examples.service.service_search;

import com.by.petranovski.library_examples.book_library.bean.Book;
import com.by.petranovski.library_examples.book_library.service.service_search.AuthorSearchCriteria;
import junit.framework.TestCase;

public class AuthorSearchCriteriaTest extends TestCase {
    private final AuthorSearchCriteria test = new AuthorSearchCriteria("authorFour");

    private final Book book1 = new Book("White Bim", "Anderson");
    private final Book book4 = new Book("Four", "authorFour");

    public void testMatchTrue() {
        assertTrue(test.match(book4));
    }

    public void testMatchFalse() {
        assertFalse(test.match(book1));
    }
}