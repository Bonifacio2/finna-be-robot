package com.twu.biblioteca;

/**
 * Created by bonifacio on 4/25/15.
 */
public class User {

    private String libraryNumber;
    private String password;

    private String name;
    private String email;
    private String phoneNumber;

    public User(String libraryNumber, String password){
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public User(String libraryNumber, String password, String name, String email, String phoneNumber){
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getLibraryNumber(){
        return this.libraryNumber;
    }

    public String getPassword(){
        return this.password;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return email;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }
}
