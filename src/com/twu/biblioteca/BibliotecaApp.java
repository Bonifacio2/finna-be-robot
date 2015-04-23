package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    private ArrayList<String> menuOptions = new ArrayList<String>();

    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }

    BibliotecaApp(){
        menuOptions.add("List Books");
        this.run();
    }

    public void listBooks(){
        System.out.println("A Game of Thrones by G.R.R. Martin, 1996");
    }

    public void selectMenuOption(String menuOption){
        if (!menuOptions.contains(menuOption)){
            System.out.println("Select a valid option!");
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
