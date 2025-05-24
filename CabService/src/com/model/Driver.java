package com.model;

public class Driver extends Person{

    private License license;

    public Driver(String name, Long personId, ContactDetail contact, License license) {
        super(name, personId, contact);
        this.license = license;
    }

    public License getLicense() {
        return license;
    }
}
