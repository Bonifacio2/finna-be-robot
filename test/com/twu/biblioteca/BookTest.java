package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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
}
