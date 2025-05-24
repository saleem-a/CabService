package com.model;

public class VehicleRegistration {


    private String plateCode;
    private Integer number;
    private ConfigCodes state;

    public VehicleRegistration(String plateCode, Integer number, ConfigCodes state) {
        this.plateCode = plateCode;
        this.number = number;
        this.state = state;
    }

    public String getPlateCode() {
        return plateCode;
    }

    public void setPlateCode(String plateCode) {
        this.plateCode = plateCode;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public ConfigCodes getState() {
        return state;
    }

    public void setState(ConfigCodes state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "VehicleRegistration{" +
                "plateCode='" + plateCode + '\'' +
                ", number=" + number +
                ", state=" + state +
                '}';
    }
}
