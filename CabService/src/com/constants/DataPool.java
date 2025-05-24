package com.constants;

import com.model.*;

import java.util.ArrayList;

public final class DataPool {

    private static final ArrayList<Vehicle> vehicles = new ArrayList<>();
    private static final ArrayList<Destination> destinations= new ArrayList<>();
    private static final ArrayList<Route> routes = new ArrayList<>();
    private static final ArrayList<Person> personDetails = new ArrayList<>();
    private static final ArrayList<ConfigCodes> configCodes = new ArrayList<>();

    private DataPool(){}

    public static ArrayList<Vehicle> getVehicles(){
       return vehicles;
    }

    public static ArrayList<Destination> getDestinations() {
        return destinations;
    }

    public static ArrayList<Route> getRoutes(){
        return routes;
    }

    public static ArrayList<Person> getPersonDetails(){
        return personDetails;
    }

    public static ArrayList<ConfigCodes> getConfigCodes(){
        return configCodes;
    }

}
