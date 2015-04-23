package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by bonifacio on 4/19/15.
 */

public class BibliotecaTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }


    @Test
    public void testWelcomingMessage() {
        BibliotecaApp biblioteca = new BibliotecaApp();

        assertThat(outContent.toString(), containsString("Welcome"));
    }

    @Test
    public void testMainMenu() {
        BibliotecaApp biblioteca = new BibliotecaApp();

        assertThat(outContent.toString(), containsString("List Books"));
    }

    @Test
    public void testBookListing() {
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.listBooks();

        assertThat(outContent.toString(), containsString("A Game of Thrones"));
    }

}
