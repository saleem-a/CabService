package com.model;

import java.util.Date;

public class CabPool {

    private Driver driver;
    private Vehicle vehicle;
    private CabBooking cabBooking;
    private Date availableDate;

    public CabPool(Driver driver, Vehicle vehicle,CabBooking cabBooking,Date availableDate) {
        this.driver = driver;
        this.vehicle = vehicle;
        this.cabBooking = cabBooking;
        this.availableDate = availableDate;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public CabBooking getCabBooking() {
        return cabBooking;
    }

    public void setCabBooking(CabBooking cabBooking) {
        this.cabBooking = cabBooking;
    }

    public Date getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(Date availableDate) {
        this.availableDate = availableDate;
    }
}
