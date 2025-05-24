package com.model;

public class ContactDetail {

    private String primaryNumber;
    private String email;
    private String alternateNumber;

    public ContactDetail(String primaryNumber,String email,String alternateNumber) {
        this.primaryNumber = primaryNumber;
        this.email = email;
        this.alternateNumber = alternateNumber;
    }
    public ContactDetail(String primaryNumber) {
        this(primaryNumber,null,null);

    }

    public String getPrimaryNumber() {
        return primaryNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAlternateNumber() {
        return alternateNumber;
    }
}
