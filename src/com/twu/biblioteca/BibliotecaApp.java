package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    private ArrayList<String> menuOptions = new ArrayList<String>();
    private ArrayList<Book> books = new ArrayList<Book>();

    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }

    BibliotecaApp(){
        menuOptions.add("List Books");

        books.add(new Book("A Game of Thrones", "G.R.R. Martin", 1996));
        this.run();
    }

    public void listBooks(){
        for (Book book : books){
            if (book.isAvailable()){
                System.out.println(book.getTitle() + " by " + book.getAuthor() + ", " + book.getYear());
            }
        }
    }

    public void selectMenuOption(String menuOption){

        if (menuOption.equals("Quit")){
            System.out.println("Bye!");
            //System.exit(0);
        } else if (!menuOptions.contains(menuOption)){
            System.out.println("Select a valid option!");
        }
    }

    public void checkoutBook(String bookTitle){
        boolean bookWasAvailable = false;

        for (Book book: books){
            if (bookTitle.equals(book.getTitle()) && book.isAvailable()){
                book.checkout();
                bookWasAvailable = true;
                break;
            }
        }

        if(bookWasAvailable){
            System.out.println("Thank you! Enjoy the book");
        } else {
            System.out.println("That book is not available.");
        }
    }

    private void run(){
        System.out.println("Welcome!");

        drawMainMenu();
    }

    private void drawMainMenu() {
        for (String menuOption : menuOptions) {
            System.out.println(menuOption);
        }
    }
}
