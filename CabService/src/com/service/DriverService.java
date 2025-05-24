package com.service;

import com.constants.DataHolder;
import com.constants.DataPool;
import com.model.*;
import com.util.FunctionUtils;

import java.util.Scanner;

public class DriverService extends PersonService {

    @Override
    public void addPerson() {
        FunctionUtils.displayMessage(DataHolder.CommonConstant.DISPLAY_DRIVER_PROFILE_OPTION);
        Scanner scanner = new Scanner(System.in);
        String driverName = scanner.nextLine();
        String[] contactDetails = FunctionUtils.processData(scanner.nextLine());
        String[] licenseDetails = FunctionUtils.processData(scanner.nextLine());
        ContactDetail contactDetail = FunctionUtils.createContactDetails(contactDetails);
        if(contactDetail == null) {
            FunctionUtils.displayMessage("Driver contact should not be empty");
            return;
        }
        License license = createDriverLicense(licenseDetails);
        if(license == null) {
            FunctionUtils.displayMessage("Driver license should not be empty");
            return;
        }
        ConfigCodeService configCodeService = new ConfigCodeService();
        ConfigCodes configCode = configCodeService.getConfigCode(DataHolder.ProfileConfig.DRIVER_PROFILE.name());
        DataPool.getPersonDetails().add(new Driver(driverName, configCode.getNumericValue() , contactDetail, license));
        updateConfiguration(configCodeService);
        FunctionUtils.displayMessage(String.format("Driver profile created successfully for %s", driverName));
    }

    @Override
    public void updateConfiguration(ConfigCodeService configCodeService) {
        configCodeService.updateConfigCode(DataHolder.ProfileConfig.DRIVER_PROFILE.name());
    }

    private License createDriverLicense(String[] licenseDetails) {
        if (licenseDetails.length == 3) {
            return new License(licenseDetails[0], FunctionUtils.convertStringToDate(licenseDetails[1]), FunctionUtils.convertStringToDate(licenseDetails[2]));
        }
        return null;
    }
}
