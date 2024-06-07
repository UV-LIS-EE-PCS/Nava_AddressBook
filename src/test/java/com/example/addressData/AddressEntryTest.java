package com.example.addressData;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AddressEntryTest {

    @Test
    public void testCompareTo() {
        // Create two AddressEntry objects
        AddressEntry entry1 = new AddressEntry();
        entry1.setLastName("Doe");

        AddressEntry entry2 = new AddressEntry();
        entry2.setLastName("Smith");

        AddressEntry entry3 = new AddressEntry();
        entry3.setLastName("Doe");

        // Compare entry1 with entry2
        assertTrue(entry1.compareTo(entry2) < 0); // Expect that Doe (entry1) is less than Smith (entry2)

        // Compare entry1 with entry3
        assertTrue(entry1.compareTo(entry3) == 0); // Expect that Doe (entry1) is equal to Doe (entry3)
    }

    @Test
    public void testGetCity() {
        AddressEntry entry = new AddressEntry();
        entry.setCity("City");
        assertEquals("City", entry.getCity());
    }

    @Test
    public void testGetEmail() {
        AddressEntry entry = new AddressEntry();
        entry.setEmail("test@example.com");
        assertEquals("test@example.com", entry.getEmail());
    }

    @Test
    public void testGetFirstName() {
        AddressEntry entry = new AddressEntry();
        entry.setFirstName("John");
        assertEquals("John", entry.getFirstName());
    }

    @Test
    public void testGetLastName() {
        AddressEntry entry = new AddressEntry();
        entry.setLastName("Doe");
        assertEquals("Doe", entry.getLastName());
    }

    @Test
    public void testGetPhone() {
        AddressEntry entry = new AddressEntry();
        entry.setPhone("1234567890");
        assertEquals("1234567890", entry.getPhone());
    }

    @Test
    public void testGetState() {
        AddressEntry entry = new AddressEntry();
        entry.setState("State");
        assertEquals("State", entry.getState());
    }

    @Test
    public void testGetStreet() {
        AddressEntry entry = new AddressEntry();
        entry.setStreet("Street");
        assertEquals("Street", entry.getStreet());
    }

    @Test
    public void testGetZip() {
        AddressEntry entry = new AddressEntry();
        entry.setZip(12345);
        assertEquals(12345, entry.getZip());
    }

    @Test
    public void testSetCity() {
        AddressEntry entry = new AddressEntry();
        entry.setCity("City");
        assertEquals("City", entry.getCity());
    }

    @Test
    public void testSetEmail() {
        AddressEntry entry = new AddressEntry();
        entry.setEmail("test@example.com");
        assertEquals("test@example.com", entry.getEmail());
    }

    @Test
    public void testSetFirstName() {
        AddressEntry entry = new AddressEntry();
        entry.setFirstName("John");
        assertEquals("John", entry.getFirstName());
    }

    @Test
    public void testSetLastName() {
        AddressEntry entry = new AddressEntry();
        entry.setLastName("Doe");
        assertEquals("Doe", entry.getLastName());
    }

    @Test
    public void testSetPhone() {
        AddressEntry entry = new AddressEntry();
        entry.setPhone("1234567890");
        assertEquals("1234567890", entry.getPhone());
    }

    @Test
    public void testSetState() {
        AddressEntry entry = new AddressEntry();
        entry.setState("State");
        assertEquals("State", entry.getState());
    }

    @Test
    public void testSetStreet() {
        AddressEntry entry = new AddressEntry();
        entry.setStreet("Street");
        assertEquals("Street", entry.getStreet());
    }

    @Test
    public void testSetZip() {
        AddressEntry entry = new AddressEntry();
        entry.setZip(12345);
        assertEquals(12345, entry.getZip());
    }

    @Test
    public void testToString() {
        AddressEntry entry = new AddressEntry();
        entry.setFirstName("John");
        entry.setLastName("Doe");
        entry.setStreet("Street");
        entry.setCity("City");
        entry.setState("State");
        entry.setZip(12345);
        entry.setEmail("test@example.com");
        entry.setPhone("1234567890");

        String expected = "AddressEntry {"
                        + "\n  First Name: John"
                        + "\n  Last Name: Doe"
                        + "\n  Street: Street"
                        + "\n  City: City"
                        + "\n  State: State"
                        + "\n  ZIP Code: 12345"
                        + "\n  Email: test@example.com"
                        + "\n  Phone: 1234567890"
                        + "\n}";
        assertEquals(expected, entry.toString());
    }
}
