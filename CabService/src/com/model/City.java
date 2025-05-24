package com.model;

public class City {

    private ConfigCodes configCode;

    public City(ConfigCodes configCode) {
        this.configCode = configCode;
    }

    public ConfigCodes getConfigCode() {
        return configCode;
    }

    public void setConfigCode(ConfigCodes configCode) {
        this.configCode = configCode;
    }

    @Override
    public String toString() {
        return "City{" +
                "configCode=" + configCode +
                '}';
    }
}
