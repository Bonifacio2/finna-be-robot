package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

/**
 * Created by bonifacio on 4/23/15.
 */
public class BookTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }


    @Test
    public void testGetTitle() {
        Book book = new Book("how to trololo", "me", 2015);
        assertEquals(book.getTitle(), "how to trololo");
    }

    @Test
    public void testGetAuthor() {
        Book book = new Book("how to trololo", "Victor Hugo", 2015);
        assertEquals(book.getAuthor(), "Victor Hugo");
    }

    @Test
    public void testGetYear() {
        Book book = new Book("how to trololo", "Victor Hugo", 2015);
        assertEquals(book.getYear(), 2015);
    }

    @Test
    public void testIsAvailable() {
        Book book = new Book("how to trololo", "Victor Hugo", 2015);
        assertTrue(book.isAvailable());
    }

    @Test
    public void testCheckout() {
        Book book = new Book("how to trololo", "Victor Hugo", 2015);
        User user = new User("123-4567", "password");

        book.checkout(user);

        assertFalse(book.isAvailable());
        assertEquals(book.getCheckedOutBy(), user);
    }

    @Test
    public void testCheckin() {
        Book book = new Book("how to trololo", "Victor Hugo", 2015);
        User user = new User("123-4567", "password");
        book.checkout(user);

        assertFalse(book.isAvailable());
        assertEquals(book.getCheckedOutBy(), user);

        book.checkin();
        assertTrue(book.isAvailable());
        assertNull(book.getCheckedOutBy());
    }
}
