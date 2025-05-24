package com.model;

import java.util.ArrayList;

public class State {

    private ConfigCodes configCode;
    private ArrayList<City> cities;

    public State(ConfigCodes configCode, ArrayList<City> cities) {
        this.configCode = configCode;
        this.cities = cities;
    }

    public State(ConfigCodes configCode) {
        this.configCode = configCode;
    }

    public ConfigCodes getConfigCode() {
        return configCode;
    }

    public void setConfigCode(ConfigCodes configCode) {
        this.configCode = configCode;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "State{" +
                "configCode=" + configCode +
                ", cities=" + cities +
                '}';
    }
}
