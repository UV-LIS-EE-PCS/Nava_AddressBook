package com.example.address;

import java.util.Scanner;

import com.example.addressData.AddressBook;

public class AddressBookApplication {

    private AddressBook addressBook;
    private Menu menu;


     public AddressBookApplication() {
        this.addressBook = new AddressBook();
        this.menu = new Menu();
    }

    public void run() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            menu.displayMenu();
            String choice = scan.nextLine();
            switch (choice) {
                case "a":
                    addressBook.change();
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
                    System.out.println("Saliendo de la aplicación...");
                    scan.close();;
                    addressBook.exit();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor intente de nuevo.");
            }
        }
    }
}
