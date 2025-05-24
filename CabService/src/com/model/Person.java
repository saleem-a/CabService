package com.model;

public class Person {

    private String name;
    private Long personId;
    private ContactDetail contact;

    public Person(String name, Long personId, ContactDetail contact) {
        this.name = name;
        this.personId = personId;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public ContactDetail getContact() {
        return contact;
    }

    public void setContact(ContactDetail contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", personId=" + personId +
                ", contact=" + contact +
                '}';
    }
}
