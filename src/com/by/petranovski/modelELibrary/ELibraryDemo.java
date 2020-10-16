package com.by.petranovski.modelELibrary;

import com.by.petranovski.modelELibrary.bean.ELibrary;
import com.by.petranovski.modelELibrary.service.ELibraryService;

import java.util.ArrayList;

public class ELibraryDemo {
    public static void main(String[] args) {
        ArrayList<String> books = new ArrayList<>();
        books.add("Tom and Jerry");
        books.add("White Bim");
        books.add("Java in the beginning");
        books.add("Clean code");
        ELibrary eLibrary = new ELibrary(books);
        ELibraryService libraryService = new ELibraryService();
        libraryService.library(eLibrary, books);
    }
}
