package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }

    BibliotecaApp(){
        this.run();
    }

    public void listBooks(){

    }


    private void run(){
        System.out.println("Welcome!");

        drawMainMenu();
    }

    private void drawMainMenu() {
        System.out.println("List Books");
    }
}
