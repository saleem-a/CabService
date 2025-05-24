package com.model;

public class ConfigCodes {

    private String  code;
    private String description;
    private Long numericValue;

    public ConfigCodes(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public ConfigCodes(String code, String description, Long numericValue) {
         this(code, description);
         this.numericValue = numericValue;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getNumericValue() {
        return numericValue;
    }

    public void setNumericValue(Long numericValue) {
        this.numericValue = numericValue;
    }

    @Override
    public String toString() {
        return "ConfigCodes{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
