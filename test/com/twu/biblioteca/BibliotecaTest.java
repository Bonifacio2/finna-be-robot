package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
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

        assertThat(outContent.toString(), containsString("A Game of Thrones by G.R.R. Martin, 1996"));
    }

    @Test
    public void testInvalidMenuOption() {
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.selectMenuOption("Launch Missile");

        assertThat(outContent.toString(), containsString("Select a valid option!"));
    }

    @Test
    public void testQuitting() {
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.selectMenuOption("Quit");

        assertThat(outContent.toString(), containsString("Bye!"));
    }

    @Test
    public void testCheckoutBook(){
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.checkoutBook("A Game of Thrones");
        biblioteca.listBooks();

        assertThat(outContent.toString(), not(containsString("A Game of Thrones")));

    }

    @Test
    public void testSuccessfulCheckout(){
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.checkoutBook("A Game of Thrones");

        assertThat(outContent.toString(), containsString("Thank you! Enjoy the book"));

    }
}
