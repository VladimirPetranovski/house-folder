package com.by.petranovski.library_examples.service.service_search;

import com.by.petranovski.library_examples.book_library.bean.Book;
import com.by.petranovski.library_examples.book_library.service.SearchCriteria;
import com.by.petranovski.library_examples.book_library.service.service_search.AuthorSearchCriteria;
import com.by.petranovski.library_examples.book_library.service.service_search.OrSearchCriteria;
import com.by.petranovski.library_examples.book_library.service.service_search.TitleSearchCriteria;
import junit.framework.TestCase;

public class OrSearchCriteriaTest extends TestCase {

    private final SearchCriteria titleToSearch = new TitleSearchCriteria("Three");
    private final SearchCriteria authorToSearch = new AuthorSearchCriteria("AuthorThree");
    private final Book book1 = new Book("One","AuthorThree");
    private final Book book2 = new Book("One","AuthorTwo");
    private final OrSearchCriteria test = new OrSearchCriteria(titleToSearch, authorToSearch);


    public void testMatchTrue() {
        assertTrue(test.match(book1));
    }

    public void testMatchFalse() {
        assertFalse(test.match(book2));
    }
}