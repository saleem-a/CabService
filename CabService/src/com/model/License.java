package com.model;

import java.util.Date;

public class License {
    private String number;
    private Date validFrom;
    private Date validTo;

    public License(String number, Date validFrom, Date validTo) {
        this.number = number;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    public String getNumber() {
        return number;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }
}
