package com.example.addressData;
import java.util.*;
import java.nio.file.Path;
import java.io.IOException;

public class AddressBook {

    ArrayList<AddressEntry> addressEntryList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    

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

    public void search() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the last name to search:");
        String lastName = scan.nextLine();
        searchByLastName(lastName);
    }

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
    
    
    public void show(){
        Collections.sort(addressEntryList);
        for (AddressEntry element : addressEntryList) {
            int counter = 0;
            counter++;
            System.out.println(counter + ": " + element);
        }
    }

    public void load() {
        Path path = Path.of("C:\\Users\\alexn\\Downloads\\data.txt");
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
   
    public void exit(){
        System.exit(0);
    }

   
}