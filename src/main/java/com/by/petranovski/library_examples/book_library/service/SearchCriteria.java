package com.by.petranovski.library_examples.book_library.service;

import com.by.petranovski.library_examples.book_library.bean.Book;

public interface SearchCriteria {

    boolean match(Book book);
}
