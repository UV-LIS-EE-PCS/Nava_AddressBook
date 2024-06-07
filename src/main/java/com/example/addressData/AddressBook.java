package com.example.addressData;
import java.util.*;
import java.nio.file.Path;
import java.io.IOException;

/**
 * AddressBook is a class that manages a collection of address entries.
 * It provides methods to add, delete, search, show, and load address entries.
 */
public class AddressBook {

    private ArrayList<AddressEntry> addressEntryList = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);

    /**
     * Adds a new address entry to the address book.
     * Prompts the user for entry details and handles input validation for the zip code.
     */
    public void add() {
        Scanner scan = new Scanner(System.in);

        System.out.println("First name:");
        String firstName = scan.nextLine();

        System.out.println("Last Name:");
        String lastName = scan.nextLine();

        System.out.println("Street:");
        String street = scan.nextLine();

        System.out.println("City:");
        String city = scan.nextLine();

        System.out.println("State:");
        String state = scan.nextLine();

        int zip;
        while (true) {
            System.out.println("Zip:");
            String zipInput = scan.nextLine();
            try {
                zip = Integer.parseInt(zipInput);
                break; 
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid zip code (numeric value).");
            }
        }

        System.out.println("Email:");
        String email = scan.nextLine();

        System.out.println("Phone:");
        String phone = scan.nextLine();

        AddressEntry newEntry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);
        addressEntryList.add(newEntry);
    }

    /**
     * Deletes an address entry from the address book.
     * Prompts the user for the last name and confirms the deletion of matching entries.
     */
    public void delete() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the last name to delete:");
        String lastName = scan.nextLine();

        Iterator<AddressEntry> iterator = addressEntryList.iterator();
        while (iterator.hasNext()) {
            AddressEntry entry = iterator.next();
            if (entry.getLastName().toLowerCase().contains(lastName.toLowerCase())) {
                System.out.println("Do you want to delete this entry? (y/n):");
                String respuesta = scan.nextLine();
                if (respuesta.equalsIgnoreCase("y")) {
                    iterator.remove();
                    System.out.println("Entry deleted.");
                }
            }
        }
    }

    /**
     * Searches for address entries by last name.
     * Prompts the user for the last name and displays matching entries.
     */
    public void search() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the last name to search:");
        String lastName = scan.nextLine();
        searchByLastName(lastName);
    }

    /**
     * Searches for address entries by last name.
     * Displays matching entries.
     * 
     * @param lastName The last name to search for.
     */
    public void searchByLastName(String lastName) {
        int counter = 0;
        System.out.println("Search results for last name '" + lastName + "':");
        for (AddressEntry entry : addressEntryList) {
            if (entry.getLastName().toLowerCase().contains(lastName.toLowerCase())) {
                System.out.println(counter + ": " + entry);
                counter++;
            }
        }
        if (counter == 0) {
            System.out.println("No results found for last name '" + lastName + "'.");
        }
    }

    /**
     * Shows all address entries in the address book.
     * The entries are displayed in sorted order.
     */
    public void show() {
        Collections.sort(addressEntryList);
        int counter = 1;
        for (AddressEntry element : addressEntryList) {
            System.out.println(counter + ": " + element);
            counter++;
        }
    }

    /**
     * Loads address entries from a file.
     * The file is expected to be located at a specified path and contain comma-separated values.
     */
    public void load() {
        Path path = Path.of("C:\\Users\\alexn\\Downloads\\datos.txt");
        try (Scanner fileScanner = new Scanner(path)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(","); // Assuming fields are separated by commas

                if (parts.length == 8) { // Make sure there are 8 parts
                    AddressEntry newEntry = new AddressEntry();
                    newEntry.setFirstName(parts[0].trim());
                    newEntry.setLastName(parts[1].trim());
                    newEntry.setStreet(parts[2].trim());
                    newEntry.setCity(parts[3].trim());
                    newEntry.setState(parts[4].trim());
                    try {
                        newEntry.setZip(Integer.parseInt(parts[5].trim())); // Convert zip to int
                    } catch (NumberFormatException e) {
                        System.out.println("Error converting zip to int: " + e.getMessage());
                        continue; // Skip this entry and continue with the next one
                    }
                    newEntry.setEmail(parts[6].trim());
                    newEntry.setPhone(parts[7].trim());

                    addressEntryList.add(newEntry); // Add the new entry without removing the existing ones
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Exits the application.
     * Terminates the program.
     */
    public void exit() {
        System.exit(0);
    }
}