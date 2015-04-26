package com.twu.biblioteca;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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
        assertThat(outContent.toString(), containsString("List Movies"));
    }

    @Test
    public void testBookListing() {
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.listBooks();

        assertThat(outContent.toString(), containsString("A Game of Thrones by G.R.R. Martin, 1996"));
    }

    @Test
    public void testMovieListing() {
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.listMovies();

        assertThat(outContent.toString(), containsString("Into The Wild directed by Sean Penn, 2007"));
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

    @Test
    public void testUnsuccessfulCheckout(){
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.checkoutBook("Musashi");

        assertThat(outContent.toString(), containsString("That book is not available."));
    }

    @Test
    public void testCheckinBook(){
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.checkoutBook("A Game of Thrones");
        biblioteca.checkinBook("A Game of Thrones");
        biblioteca.listBooks();

        assertThat(outContent.toString(), containsString("A Game of Thrones"));
    }

    @Test
    public void testSuccessfulCheckin(){
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.checkoutBook("A Game of Thrones");
        biblioteca.checkinBook("A Game of Thrones");

        assertThat(outContent.toString(), containsString("Thank you for returning the book."));
    }

    @Test
    public void testUnsuccessfulCheckin(){
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.checkinBook("Musashi");

        assertThat(outContent.toString(), containsString("That is not a valid book to return."));
    }

    @Test
    public void testLogin(){
        BibliotecaApp biblioteca = new BibliotecaApp();
        assertTrue(biblioteca.login("123-4567", "password"));
        assertEquals(biblioteca.getCurrentUser().getLibraryNumber(), "123-4567");

        assertFalse(biblioteca.login("123-4567", "wrongPassword"));
    }

    @Test
    public void testShowCurrentUserInformation(){
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.login("123-4567", "password");
        biblioteca.showCurrentUserInformation();

        assertThat(outContent.toString(), containsString("Name: bonifacio"));
        assertThat(outContent.toString(), containsString("Mail: bonifacio@mail.com"));
        assertThat(outContent.toString(), containsString("Phone: 2345678"));

        biblioteca.login("999-9999", "password");
        biblioteca.showCurrentUserInformation();

        assertThat(outContent.toString(), containsString("Name: somebody"));
        assertThat(outContent.toString(), containsString("Mail: somebody@mail.com"));
        assertThat(outContent.toString(), containsString("Phone: 1111111"));
    }

}
