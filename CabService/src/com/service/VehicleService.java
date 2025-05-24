package com.service;

import com.constants.DataHolder;
import com.constants.DataPool;
import com.model.*;
import com.util.FunctionUtils;
import com.validator.VehicleValidator;

import java.util.ArrayList;
import java.util.Scanner;

public class VehicleService {

    public void validateAndAddVehicle(String vehicleClass, String type, String brand, String stateCode, String plateNumber) {
        ArrayList<String> errors = VehicleValidator.validateVehicle(vehicleClass, type, brand, stateCode, plateNumber);
        if (!errors.isEmpty()) {
            FunctionUtils.displayMessage(errors);
            return;
        }
        DataPool.getVehicles().add(addVehicle(vehicleClass, type, brand, stateCode, plateNumber));
        FunctionUtils.displayMessage(DataHolder.SuccessMessage.RECORD_CREATE_SUCCESSFULLY);
    }

    private Vehicle addVehicle(String vehicleClass, String type, String brand, String stateCode, String plateNumber) {
        String[] codes = plateNumber.split("-");
        String[] stateConfigCode = FunctionUtils.getStateConfig(stateCode);
        VehicleRegistration registration = new VehicleRegistration(codes[0], Integer.parseInt(codes[1]), new ConfigCodes(stateConfigCode[0], stateConfigCode[1]));
        return DataHolder.VehicleClass.ECONOMIC.getCode().equalsIgnoreCase(vehicleClass) ?
                new EconomicVehicle(FunctionUtils.toUpperCase(type), FunctionUtils.toUpperCase(brand), registration) :
                new LuxuryVehicle(FunctionUtils.toUpperCase(type), FunctionUtils.toUpperCase(brand), registration);
    }

    public void createVehicle() {
        Scanner scanner = new Scanner(System.in);
        String vehicleClass = scanner.nextLine();
        String type = scanner.nextLine();
        String brand = scanner.nextLine();
        String stateCode = scanner.nextLine();
        String plateNumber = scanner.nextLine();
        validateAndAddVehicle(vehicleClass, type, brand, stateCode, plateNumber);
    }

    public void listAllVehicles() {
        if (DataPool.getVehicles().isEmpty()) {
            FunctionUtils.displayMessage(DataHolder.ErrorMessage.NO_DATA_FOUND);
            return;
        }

        FunctionUtils.displayMessage(String.format("%s %s %s %s", "Class", "Type", "Brand", "Registration"));
        for (Vehicle vehicle : DataPool.getVehicles()) {
            String classStr = (vehicle instanceof LuxuryVehicle) ? DataHolder.VehicleClass.LUXURY.name() : DataHolder.VehicleClass.ECONOMIC.name();
            DataHolder.VehicleType[] types = DataHolder.VehicleType.values();
            String typeStr = "";
            for (DataHolder.VehicleType type : types) {
                if (type.getCode().equals(vehicle.getType())) {
                    typeStr = type.name();
                }
            }
            DataHolder.VehicleBrand[] brands = DataHolder.VehicleBrand.values();
            String brandStr = "";
            for (DataHolder.VehicleBrand brand : brands) {
                if (brand.getCode().equals(vehicle.getBrand())) {
                    brandStr = brand.name();
                }
            }

            String registration = vehicle.getRegistration().getState().getCode() + "-" + vehicle.getRegistration().getPlateCode() + "-" + vehicle.getRegistration().getNumber();

            FunctionUtils.displayMessage(String.format("%s %s %s %s", classStr, typeStr,
                    brandStr, registration));
        }

    }
}
