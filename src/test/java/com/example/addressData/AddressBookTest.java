package com.example.addressData;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class AddressBookTest {
    private List<AddressEntry> addressEntryList;

    @BeforeEach
    public void setUp() {
        addressEntryList = new ArrayList<>();
    }

    @Test
    public void testAdd() {
        AddressEntry entry = new AddressEntry("John", "Doe", "123 Street", "City", "State", 12345, "john.doe@example.com", "1234567890");
        addressEntryList.add(entry);
        assertTrue(addressEntryList.contains(entry));
    }


    @Test
    public void testDelete() {
        AddressEntry entry = new AddressEntry("John", "Doe", "123 Street", "City", "State", 12345, "john.doe@example.com", "1234567890");
        addressEntryList.add(entry);
        addressEntryList.remove(entry);
        assertFalse(addressEntryList.contains(entry));
    }


    @Test
    public void testSearch() {
        AddressEntry entry = new AddressEntry("John", "Doe", "123 Street", "City", "State", 12345, "john.doe@example.com", "1234567890");
        addressEntryList.add(entry);
        AddressEntry result = search("Doe");
        assertEquals(entry, result);
    }

    @Test
    public void testSearchByLastName() {
        AddressEntry entry1 = new AddressEntry("John", "Doe", "123 Street", "City", "State", 12345, "john.doe@example.com", "1234567890");
        AddressEntry entry2 = new AddressEntry("Jane", "Doe", "456 Avenue", "Town", "State", 67890, "jane.doe@example.com", "9876543210");
        addressEntryList.add(entry1);
        addressEntryList.add(entry2);
        List<AddressEntry> results = searchByLastName("Doe");
        assertEquals(2, results.size());
        assertTrue(results.contains(entry1));
        assertTrue(results.contains(entry2));
    }

    // It doesn't work
    @Test
    public void testShow() {
        AddressEntry entry1 = new AddressEntry("John", "Doe", "123 Street", "City", "State", 12345, "john.doe@example.com", "1234567890");
        AddressEntry entry2 = new AddressEntry("Jane", "Smith", "456 Avenue", "Town", "State", 67890, "jane.smith@example.com", "9876543210");
        addressEntryList.add(entry1);
        addressEntryList.add(entry2);

        // Capture the console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        show();

        // Verify the console output
        String expectedOutput = "1: " + entry1.toString() + "\n2: " + entry2.toString() + "\n";
        assertEquals(expectedOutput, outContent.toString().trim());

        // Restore the standard outputs
        System.setOut(System.out);
    }

    private AddressEntry search(String lastName) {
        for (AddressEntry entry : addressEntryList) {
            if (entry.getLastName().equalsIgnoreCase(lastName)) {
                return entry;
            }
        }
        return null;
    }

    private List<AddressEntry> searchByLastName(String lastName) {
        List<AddressEntry> results = new ArrayList<>();
        for (AddressEntry entry : addressEntryList) {
            if (entry.getLastName().equalsIgnoreCase(lastName)) {
                results.add(entry);
            }
        }
        return results;
    }

    private void show() {
        int counter = 1;
        for (AddressEntry entry : addressEntryList) {
            System.out.println(counter + ": " + entry);
            counter++;
        }
    }
}

    
    
