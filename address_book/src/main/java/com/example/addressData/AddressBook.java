package com.example.addressData;
import java.util.*;
import java.nio.file.Path;
import java.io.IOException;

public class AddressBook {

    ArrayList<AddressEntry> addressEntryList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    

    public void add(){
        
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

        System.out.println("Zip:");
        int zip = scan.nextInt();

        System.out.println("Email:");
        String email = scan.nextLine();

        System.out.println("Phone:");
        String phone = scan.nextLine();

        AddressEntry newEntry = new AddressEntry(firstName,lastName,street,city,state,zip,email,phone);
        addressEntryList.add(newEntry);
    }

    public void delete(){

        int contador = 0;
        System.out.println("Ingrese el apellido a eliminar:");
        String lastName = scan.nextLine();
        for (AddressEntry elemento : addressEntryList) {
            if(subString(elemento.getLastName(),lastName))
            System.out.println(contador + ": " + elemento);
            addressEntryList.remove(elemento);
        }
    }

    public void Search(){
        int contador = 0;
        System.out.println("Ingrese el apellido a buscar:");
        String lastName = scan.nextLine();
        for (AddressEntry elemento : addressEntryList) {
            if(subString(elemento.getLastName(),lastName)){
            System.out.println(contador + ": " + elemento);
            }
        }
    }
    
    
    public void Show(){
        Collections.sort(addressEntryList);

        for (AddressEntry elemento : addressEntryList) {
            int contador = 0;
            contador++;
            System.out.println(contador + ": " + elemento);
        }
    }

    

    public static boolean subString(String cadena, String patron) {
        // Convertir el patrón de SQL LIKE a una expresión regular de Java
        String regex = patron.replace("%", ".*").replace("_", ".");
        // Devuelve true si la cadena coincide con el patrón
        return cadena.matches(regex);
    }


    public void change(){
        Path path = Path.of("AmadorQuispe.txt");

        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}