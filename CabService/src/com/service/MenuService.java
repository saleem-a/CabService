package com.service;

import com.constants.DataHolder;
import com.model.Customer;
import com.model.Driver;
import com.util.FunctionUtils;

import java.util.Scanner;


public class MenuService {

    public void showHomePage() {
        FunctionUtils.displayMessage(DataHolder.CommonConstant.DISPLAY_MAIN_MENU);
        Scanner scanner = new Scanner(System.in);
        showMenuItemByMenu(scanner.nextLine());
    }

    public void showMenuItemByMenu(String code) {
        if (DataHolder.CommonConstant.QUIT_OPTION.contains(code)) {
            quitApplication();
        }
        VehicleService vehicleService;
        RouteService routeService;
        PersonService personService;
        CabBookingService cabBookingService;
        switch (code) {
            case "AV", "av":
                FunctionUtils.displayMessage(DataHolder.CommonConstant.DISPLAY_VEHICLE_INFO);
                vehicleService = new VehicleService();
                vehicleService.createVehicle();
                break;
            case "LV", "lv":
                vehicleService = new VehicleService();
                vehicleService.listAllVehicles();
                break;
            case "DS","ds":
                DestinationService destinationService = new DestinationService();
                destinationService.listDestinations();
                break;
            case "CR","cr":
                routeService = new RouteService();
                routeService.addRoutes();
                break;
            case "RL","rl":
                routeService = new RouteService();
                routeService.listRoutes();
                break;
            case "AD","ad":
                personService = new DriverService();
                personService.addPerson();
                break;
            case "AC","ac":
                personService = new CustomerService();
                personService.addPerson();
                break;
            case "DL","dl":
                personService = new DriverService();
                personService.getPerson(Driver.class.getSimpleName());
                break;
            case "CL","cl":
                personService = new CustomerService();
                personService.getPerson(Customer.class.getSimpleName());
                break;
            case "CB","cb":
                cabBookingService= new CabBookingService();
                cabBookingService.createBooking();
                break;
            default:
                FunctionUtils.displayMessage("Please enter valid option.");
        }
        displayHomeMessage();
    }

    private void displayHomeMessage() {
        FunctionUtils.displayMessage(DataHolder.CommonConstant.DISPLAY_USER_ACTION);
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();
        if (DataHolder.CommonConstant.QUIT_OPTION.contains(code)) {
            quitApplication();
        }
        showHomePage();
    }

    private void quitApplication() {
        FunctionUtils.displayMessage("Good bye!!!");
        System.exit(0);
    }
}
