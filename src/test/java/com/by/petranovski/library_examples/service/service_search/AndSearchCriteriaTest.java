package com.by.petranovski.library_examples.service.service_search;

import com.by.petranovski.library_examples.book_library.bean.Book;
import com.by.petranovski.library_examples.book_library.service.SearchCriteria;
import com.by.petranovski.library_examples.book_library.service.service_search.AndSearchCriteria;
import com.by.petranovski.library_examples.book_library.service.service_search.AuthorSearchCriteria;
import com.by.petranovski.library_examples.book_library.service.service_search.TitleSearchCriteria;
import junit.framework.TestCase;

public class AndSearchCriteriaTest extends TestCase {
    private final SearchCriteria titleToSearch = new TitleSearchCriteria("One");
    private final SearchCriteria authorToSearch = new AuthorSearchCriteria("AuthorOne");
    private final Book book1 = new Book("One", "AuthorOne");
    private final Book book2 = new Book("Two", "AuthorOne");
    private final AndSearchCriteria test = new AndSearchCriteria(titleToSearch, authorToSearch);

    public void testMatchTrue() {
        assertTrue(test.match(book1));
    }

    public void testMatchFalse() {
        assertFalse(test.match(book2));
    }
}