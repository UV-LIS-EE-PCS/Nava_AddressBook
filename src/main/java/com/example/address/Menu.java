package com.example.address;

/**
 * Menu class is responsible for displaying the menu options to the user.
 * It provides a method to print the menu to the console.
 */
public class Menu {

    /**
     * Displays the menu options to the user.
     * This method prints the available actions that the user can choose from.
     */
    public void displayMenu() {
        System.out.println("-----------------");
        System.out.println("Choose an option from the menu");
        System.out.println("a) Load from file");
        System.out.println("b) Add");
        System.out.println("c) Delete");
        System.out.println("d) Search");
        System.out.println("e) Show");
        System.out.println("f) Exit");
    }
}

