package com.twu.biblioteca;

/**
 * Created by bonifacio on 4/23/15.
 */
public class Book {

    private String title;
    private String author;
    private int year;
    private boolean available;

    Book(String title, String author, int year){
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = true;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable(){
        return available;
    }

    public void checkout(){
        this.available = false;
    }

    public void checkin(){
        this.available = true;
    }
}
