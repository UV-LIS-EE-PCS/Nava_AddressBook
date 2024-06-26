package com.example.addressData;

public class AddressEntry implements Comparable<AddressEntry>{
    
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private int zip;
    private String email;
    private String phone;

    public AddressEntry(){

    }

    public AddressEntry(String firstName, String lastName, String street,String city, String state, int zip, String email, String phone){
            this.firstName = firstName;
            this.lastName = lastName;
            this.street = street;
            this.city = city;
            this.state = state;
            this.zip = zip;
            this.email = email;
            this.phone = phone; 
    }

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int compareTo(AddressEntry a) {
        return this.getLastName().compareTo(a.getLastName());
    }
    
}
