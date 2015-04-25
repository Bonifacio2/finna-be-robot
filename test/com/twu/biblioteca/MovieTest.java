package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by bonifacio on 4/25/15.
 */
public class MovieTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }


    @Test
    public void testGetName(){
        Movie intoTheWild = new Movie("Into The Wild", 2007, "Sean Penn", 10);
        Movie theUntouchables = new Movie("The Untouchables", 1987, "Brian De Palma", 9);

        assertTrue(intoTheWild.getTitle().equals("Into The Wild"));
        assertTrue(theUntouchables.getTitle().equals("The Untouchables"));
    }

    @Test
    public void testGetYear(){
        Movie intoTheWild = new Movie("Into The Wild", 2007, "Sean Penn", 10);
        Movie theUntouchables = new Movie("The Untouchables", 1987, "Brian De Palma", 9);

        assertEquals(intoTheWild.getYear(), 2007);
        assertEquals(theUntouchables.getYear(), 1987);
    }

    @Test
    public void testGetDirector(){
        Movie intoTheWild = new Movie("Into The Wild", 2007, "Sean Penn", 10);
        Movie theUntouchables = new Movie("The Untouchables", 1987, "Brian De Palma", 9);

        assertTrue(intoTheWild.getDirector().equals("Sean Penn"));
        assertTrue(theUntouchables.getDirector().equals("Brian De Palma"));
    }
}
