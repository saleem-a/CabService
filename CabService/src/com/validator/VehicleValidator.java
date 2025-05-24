package com.validator;

import com.constants.DataHolder;

import java.util.ArrayList;
import java.util.regex.Pattern;

public final class VehicleValidator {

    private VehicleValidator() {
    }

    public static ArrayList<String> validateVehicle(String vehicleClass, String type, String brand, String stateCode, String plateNumber) {
        ArrayList<String> errors = new ArrayList<>();
        validateVehicleClass(errors, vehicleClass);
        validateVehicleType(errors, type);
        validateVehicleBrand(errors, brand);
        validateVehicleState(errors, stateCode);
        validatePlateNumber(errors, plateNumber);
        return errors;
    }

    private static void validateVehicleState(ArrayList<String> errors, String stateCode) {
        boolean isValidCode = false;
        ArrayList<String[]> states = DataHolder.states;
        for (String[] state : states) {
            if (state[0].equalsIgnoreCase(stateCode)) {
                isValidCode = true;
                break;
            }
        }
        if (!isValidCode)
            errors.add(DataHolder.ErrorMessage.INVALID_STATE_CODE);
    }

    private static void validateVehicleBrand(ArrayList<String> errors, String brand) {
        boolean isValidBrand = false;
        for (DataHolder.VehicleBrand vehicleBrand : DataHolder.VehicleBrand.values()) {
            if (vehicleBrand.getCode().equalsIgnoreCase(brand)) {
                isValidBrand = true;
                break;
            }
        }
        if (!isValidBrand)
            errors.add(DataHolder.ErrorMessage.INVALID_VEHICLE_BRAND);
    }

    private static void validateVehicleType(ArrayList<String> errors, String type) {
        boolean isValidType = false;
        for (DataHolder.VehicleType vehicleType : DataHolder.VehicleType.values()) {
            if (vehicleType.getCode().equalsIgnoreCase(type)) {
                isValidType = true;
                break;
            }
        }
        if (!isValidType)
            errors.add(DataHolder.ErrorMessage.INVALID_VEHICLE_TYPE);
    }

    private static void validateVehicleClass(ArrayList<String> errors, String vehicleClass) {
        if (!DataHolder.VehicleClass.ECONOMIC.getCode().equalsIgnoreCase(vehicleClass)
                && !DataHolder.VehicleClass.LUXURY.getCode().equalsIgnoreCase(vehicleClass))
            errors.add(DataHolder.ErrorMessage.INVALID_VEHICLE_CLASS);
    }

    private static void validatePlateNumber(ArrayList<String> errors, String plateNumber) {
        if (!Pattern.matches("^[a-zA-z_0-9-]+$", plateNumber))
            errors.add(DataHolder.ErrorMessage.INVALID_VEHICLE_PLATE);
    }
}
