package com.twu.biblioteca;

/**
 * Created by bonifacio on 4/23/15.
 */
public class Book {

    String title;
    String author;
    int year;

    Book(String title, String author, int year){
        this.title = title;
        this.author = author;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }
}
