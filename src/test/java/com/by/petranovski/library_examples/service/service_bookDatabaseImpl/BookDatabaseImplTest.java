package com.by.petranovski.library_examples.service.service_bookDatabaseImpl;

import com.by.petranovski.library_examples.book_library.bean.Book;
import com.by.petranovski.library_examples.book_library.service.SearchCriteria;
import com.by.petranovski.library_examples.book_library.service.service_bookDatabaseImpl.BookDatabaseImpl;
import com.by.petranovski.library_examples.book_library.service.service_search.AuthorSearchCriteria;
import com.by.petranovski.library_examples.book_library.service.service_search.OrSearchCriteria;
import com.by.petranovski.library_examples.book_library.service.service_search.TitleSearchCriteria;
import junit.framework.TestCase;
import org.junit.Before;

import java.util.*;

public class BookDatabaseImplTest extends TestCase {
    private final BookDatabaseImpl test = new BookDatabaseImpl();

    private final SearchCriteria titleSearchCriteria = new TitleSearchCriteria("White Bim");
    private final SearchCriteria authorSearchCriteria = new AuthorSearchCriteria("Pushkin");
    private final SearchCriteria searchCriteria = new OrSearchCriteria(titleSearchCriteria, authorSearchCriteria);


    private final Book book1 = new Book("White Bim", "Anderson", "2000");
    private final Book book2 = new Book("An black ear", "Pushkin", "1998");
    private final Book book3 = new Book("Tom and Jerry", "Tim Silvia", "1984");
    private final Book book4 = new Book("Four", "authorFour");
    private final Book book5 = new Book("Five", "Pushkin");
    private final Book book6 = new Book("White Bim", "authorSix");
    private final Book book7 = new Book("White Bim", "authorSix");

    private final Set<Book> list = new HashSet<>();

    @Before
    public void setUp() {
        test.save(book1);
        test.save(book2);
        test.save(book3);
        test.save(book4);
        test.save(book5);
        test.save(book6);

        list.add(book1);
        list.add(book2);
        list.add(book3);
        list.add(book4);
        list.add(book5);
        list.add(book6);
    }

    public void testSave() {
        Long expected = 7L;
        assertEquals(expected, test.save(book1));
    }

    public void testDeleteIdTrue() {
        assertTrue(test.delete(1L));
    }

    public void testDeleteIdFalse() {
        assertFalse(test.delete(7L));
    }

    public void testIsExistBookTrue() {
        assertTrue(test.isExistBook(1L));
    }

    public void testIsExistBookFalse() {
        assertFalse(test.isExistBook(8L));
    }

    public void testDeleteBookTrue() {
        assertTrue(test.delete(book2));
    }

    public void testDeleteBookFalse() {
        assertFalse(test.delete(book7));
    }

    public void testFindBookTrue() {
        assertTrue(test.findBook(book1));
    }

    public void testFindBookFalse() {
        assertFalse(test.findBook(book7));
    }

    public void testFindByIdBook() {
        assertEquals(Optional.of(book1), test.findById(1L));
    }

    public void testFindByIdEmpty() {
        assertEquals(Optional.empty(), test.findById(7L));
    }

    public void testFindByAuthor() {
        List<Book> expected = new ArrayList<>();
        expected.add(book2);
        expected.add(book5);
        assertEquals(expected, test.findByAuthor("Pushkin"));
    }

    public void testFindByTitle() {
        List<Book> expected = new ArrayList<>();
        expected.add(book3);
        assertEquals(expected, test.findByTitle("tom and jerry"));
    }

    public void testCountAllBooks() {
        assertEquals(6, test.countAllBooks());
    }

    public void testDeleteByAuthor() {
        Set<Book> expected = new HashSet<>();
        expected.add(book1);
        expected.add(book2);
        expected.add(book4);
        expected.add(book5);
        expected.add(book6);
        list.removeAll(test.findByAuthor("Tim Silvia"));
        assertEquals(expected, list);
    }


    public void testDeleteByTitle() {
        Set<Book> expected = new HashSet<>();
        expected.add(book1);
        expected.add(book2);
        expected.add(book3);
        expected.add(book4);
        expected.add(book6);
        list.removeAll(test.findByTitle("Five"));
        assertEquals(expected, list);
    }

    public void testFind() {
        List<Book> expected = Arrays.asList(book1, book2, book5, book6);
        assertEquals(expected, test.find(searchCriteria));
    }

    public void testFindUniqueAuthors() {
        Set<String> expected = new HashSet<>();
        expected.add("Anderson");
        expected.add("Pushkin");
        expected.add("Tim Silvia");
        expected.add("authorFour");
        expected.add("authorSix");
        assertEquals(expected, test.findUniqueAuthors());
    }

    public void testFindByUniqueTitle() {
        Set<String> expected = new HashSet<>();
        expected.add("White Bim");
        expected.add("An black ear");
        expected.add("Four");
        expected.add("Tom and Jerry");
        expected.add("Five");
        assertEquals(expected, test.findUniqueTitles());
    }

    public void testFindUniqueBooks() {
        assertEquals(list, test.findUniqueBooks());
    }

    public void testContains() {
        assertTrue(test.contains(book3));
    }

    public void testTestFind() {
        String text = "Mama Mila ramu";
        String[] splitText = {"Mama", "Mila", "ramu"};
        Set<String> expected = new HashSet<>(Arrays.asList(splitText));
        assertEquals(expected, test.find(text));
    }

    public void testGetAuthorToBooksMap() {
        Map<String, List<Book>> expected = new HashMap<>();
        List<Book> books = Arrays.asList(book1);
        expected.put("Anderson", books);
        List<Book> books1 = Arrays.asList(book2, book5);
        expected.put("Pushkin", books1);
        List<Book> books2 = Arrays.asList(book3);
        expected.put("Tim Silvia", books2);
        List<Book> books3 = Arrays.asList(book4);
        expected.put("authorFour", books3);
        List<Book> books4 = Arrays.asList(book6);
        expected.put("authorSix", books4);
        assertEquals(expected, test.getAuthorToBooksMap());
    }

    public void testGetEachAuthorBookCount() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("Anderson", 1);
        expected.put("Pushkin", 2);
        expected.put("Tim Silvia", 1);
        expected.put("authorFour", 1);
        expected.put("authorSix", 1);
        assertEquals(expected, test.getEachAuthorBookCount());
    }
}