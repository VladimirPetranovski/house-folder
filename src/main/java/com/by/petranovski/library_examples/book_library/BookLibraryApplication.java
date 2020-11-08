package com.by.petranovski.library_examples.book_library;

import com.by.petranovski.library_examples.book_library.DAO_bookLibrary.BookLibrary;

class BookLibraryApplication {
    public static void main(String[] args) {
        BookLibrary bookLibrary = new BookLibrary();
        bookLibrary.run();
    }
}
