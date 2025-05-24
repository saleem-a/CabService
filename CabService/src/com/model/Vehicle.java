package com.model;

public class Vehicle {

    private String type;
    private String brand;
    private VehicleRegistration registration;

    public Vehicle(String type, String brand, VehicleRegistration registration) {
        this.type = type;
        this.brand = brand;
        this.registration = registration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public VehicleRegistration getRegistration() {
        return registration;
    }

    public void setRegistration(VehicleRegistration registration) {
        this.registration = registration;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", registration=" + registration +
                '}';
    }
}
