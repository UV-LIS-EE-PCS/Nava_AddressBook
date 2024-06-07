package com.example.addressData;

/**
 * AddressEntry class represents a single entry in an address book.
 * It contains personal information such as name, address, email, and phone number.
 */
public class AddressEntry implements Comparable<AddressEntry> {
    
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private int zip;
    private String email;
    private String phone;

    /**
     * Default constructor for AddressEntry.
     */
    public AddressEntry() {
    }

    /**
     * Parameterized constructor for AddressEntry.
     * 
     * @param firstName The first name of the person.
     * @param lastName The last name of the person.
     * @param street The street address.
     * @param city The city.
     * @param state The state.
     * @param zip The ZIP code.
     * @param email The email address.
     * @param phone The phone number.
     */
    public AddressEntry(String firstName, String lastName, String street, String city, String state, int zip, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.phone = phone;
    }

    /**
     * Returns a string representation of the AddressEntry.
     * 
     * @return A formatted string with the address entry details.
     */
    @Override
    public String toString() {
        return "AddressEntry {" +
                "\n  First Name: " + getFirstName() +
                "\n  Last Name: " + getLastName() +
                "\n  Street: " + getStreet() +
                "\n  City: " + getCity() +
                "\n  State: " + getState() +
                "\n  ZIP Code: " + getZip() +
                "\n  Email: " + getEmail() +
                "\n  Phone: " + getPhone() +
                "\n}";
    }

    // Getters and setters for each field with JavaDoc comments

    /**
     * Gets the first name of the person.
     * 
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the person.
     * 
     * @param firstName The first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the person.
     * 
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the person.
     * 
     * @param lastName The last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the street address.
     * 
     * @return The street address.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the street address.
     * 
     * @param street The street address to set.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Gets the city.
     * 
     * @return The city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city.
     * 
     * @param city The city to set.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the state.
     * 
     * @return The state.
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state.
     * 
     * @param state The state to set.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the ZIP code.
     * 
     * @return The ZIP code.
     */
    public int getZip() {
        return zip;
    }

    /**
     * Sets the ZIP code.
     * 
     * @param zip The ZIP code to set.
     */
    public void setZip(int zip) {
        this.zip = zip;
    }

    /**
     * Gets the email address.
     * 
     * @return The email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address.
     * 
     * @param email The email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the phone number.
     * 
     * @return The phone number.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number.
     * 
     * @param phone The phone number to set.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Compares this AddressEntry to another by last name.
     * 
     * @param a The AddressEntry to compare to.
     * @return A negative integer, zero, or a positive integer as this object's last name is less than, equal to, or greater than the specified object's last name.
     */
    @Override
    public int compareTo(AddressEntry a) {
        return this.getLastName().compareTo(a.getLastName());
    }
}
