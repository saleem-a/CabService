package com.service;

import com.constants.DataHolder;
import com.constants.DataPool;
import com.model.Destination;
import com.model.Route;
import com.util.FunctionUtils;

import java.util.Scanner;

public class RouteService {

    public void addRoutes(){
        FunctionUtils.displayMessage(DataHolder.CommonConstant.DISPLAY_ROUTE_OPTION);
        Scanner scanner= new Scanner(System.in);
        String[] fromRoute=FunctionUtils.processData(scanner.nextLine());
        String[] toRoute=FunctionUtils.processData(scanner.nextLine());
        DestinationService destinationService= new DestinationService();
        Destination fromDestination=destinationService.getDestinationByStateCityCode(fromRoute[0],fromRoute[1]);
        Destination toDestination=destinationService.getDestinationByStateCityCode(toRoute[0],toRoute[1]);
        if(fromDestination != null && toDestination != null){
            DataPool.getRoutes().add(new Route(fromDestination,toDestination));
            DataPool.getRoutes().add(new Route(toDestination, fromDestination));
        }
    }

    public void listRoutes() {
        if(DataPool.getRoutes().isEmpty()){
            FunctionUtils.displayMessage("No Routes found");
            return;
        }
        for(Route route: DataPool.getRoutes()){
            FunctionUtils.displayMessage(String.format("%s - %s ==>  %s - %s", route.getFromLocation().getState().getConfigCode().getDescription(),
                    route.getFromLocation().getCity().getConfigCode().getDescription(),
                    route.getToLocation().getState().getConfigCode().getDescription(),
                    route.getToLocation().getCity().getConfigCode().getDescription()));

        }
    }
}
