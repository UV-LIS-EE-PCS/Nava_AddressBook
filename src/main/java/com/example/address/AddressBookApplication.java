package com.example.address;
import java.util.Scanner;
import com.example.addressData.AddressBook;

/**
 * AddressBookApplication is the main class that manages the execution of the address book application.
 * It uses an instance of AddressBook to handle address book operations and an instance of Menu
 * to display menu options to the user.
 */
public class AddressBookApplication {

    private AddressBook addressBook;
    private Menu menu;

    /**
     * Constructor of the AddressBookApplication class.
     * Initializes a new address book and the menu.
     */
    public AddressBookApplication() {
        this.addressBook = new AddressBook();
        this.menu = new Menu();
    }

    /**
     * Main method that runs the main loop of the application.
     * Displays the menu and handles user selections.
     */
    public void run() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            menu.displayMenu();
            String choice = scan.nextLine();
            switch (choice) {
                case "a":
                    addressBook.load();
                    break;
                case "b":
                    addressBook.add();
                    break;
                case "c":
                    addressBook.delete();
                    break;
                case "d":
                    addressBook.search();
                    break;
                case "e":
                    addressBook.show();
                    break;
                case "f":
                    System.out.println("Exiting the application...");
                    scan.close();
                    addressBook.exit();
                    return;  // Use return to exit the method and end the loop
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}