package com.by.petranovski.library_examples.service.service_search;

import com.by.petranovski.library_examples.book_library.bean.Book;
import com.by.petranovski.library_examples.book_library.service.service_search.TitleSearchCriteria;
import junit.framework.TestCase;

public class TitleSearchCriteriaTest extends TestCase {
    private final TitleSearchCriteria test = new TitleSearchCriteria("Six");

    private final Book book4 = new Book("Four", "authorFour");
    private final Book book6 = new Book("Six", "authorSix");

    public void testMatchTrue() {
        assertTrue(test.match(book6));
    }

    public void testMatchFalse() {
        assertFalse(test.match(book4));
    }
}