package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by bonifacio on 4/25/15.
 */
public class UserTest {

    @Test
    public void testGetLibraryNumber(){
        User user = new User("123-4567", "password", "bonifacio", "bonifacio@mail.com", "2345678");
        User anotherUser = new User("765-4321", "differentPassword", "anotherperson", "somebodyelse@mail.com", "8765432");

        assertEquals(user.getLibraryNumber(), "123-4567");
        assertEquals(anotherUser.getLibraryNumber(), "765-4321");
    }

    @Test
    public void testGetPassword(){
        User user = new User("123-4567", "password", "bonifacio", "bonifacio@mail.com", "2345678");
        User anotherUser = new User("765-4321", "differentPassword", "anotherperson", "somebodyelse@mail.com", "8765432");

        assertEquals(user.getPassword(), "password");
        assertEquals(anotherUser.getPassword(), "differentPassword");
    }

    @Test
    public void testGetName(){
        User user = new User("123-4567", "password", "bonifacio", "bonifacio@mail.com", "2345678");
        User anotherUser = new User("765-4321", "differentPassword", "anotherperson", "somebodyelse@mail.com", "8765432");

        assertEquals(user.getName(), "bonifacio");
        assertEquals(anotherUser.getName(), "anotherperson");
    }

    @Test
    public void testGetEmail(){
        User user = new User("123-4567", "password", "bonifacio", "bonifacio@mail.com", "2345678");
        User anotherUser = new User("765-4321", "differentPassword", "anotherperson", "somebodyelse@mail.com", "8765432");

        assertEquals(user.getEmail(), "bonifacio@mail.com");
        assertEquals(anotherUser.getEmail(), "somebodyelse@mail.com");
    }

    @Test
    public void testGetPhoneNumber(){
        User user = new User("123-4567", "password", "bonifacio", "bonifacio@mail.com", "2345678");
        User anotherUser = new User("765-4321", "differentPassword", "anotherperson", "somebodyelse@mail.com", "8765432");

        assertEquals(user.getPhoneNumber(), "2345678");
        assertEquals(anotherUser.getPhoneNumber(), "8765432");
    }
}
