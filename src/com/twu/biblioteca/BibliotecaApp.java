package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    private ArrayList<String> menuOptions = new ArrayList<String>();
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<Movie> movies = new ArrayList<Movie>();

    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }

    BibliotecaApp(){
        menuOptions.add("List Books");
        menuOptions.add("List Movies");

        books.add(new Book("A Game of Thrones", "G.R.R. Martin", 1996));
        movies.add(new Movie("Into The Wild", 2007, "Sean Penn", 10));
        this.run();
    }

    public void listBooks(){
        for (Book book : books){
            if (book.isAvailable()){
                System.out.println(book.getTitle() + " by " + book.getAuthor() + ", " + book.getYear());
            }
        }
    }

    public void listMovies(){
        for (Movie movie: movies){
            if (movie.isAvailable()){
                System.out.println(movie.getTitle() + " directed by " + movie.getDirector() + ", " + movie.getYear());
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

    public void checkinBook(String bookTitle){
        boolean bookExists = false;

        for (Book book: books){
            if (bookTitle.equals(book.getTitle()) && !book.isAvailable()){
                book.checkin();
                bookExists = true;
                break;
            }
        }

        if(bookExists){
            System.out.println("Thank you for returning the book.");
        } else {
            System.out.println("That is not a valid book to return.");
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
