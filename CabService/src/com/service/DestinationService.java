package com.service;

import com.constants.DataHolder;
import com.constants.DataPool;
import com.model.City;
import com.model.ConfigCodes;
import com.model.Destination;
import com.model.State;
import com.util.FunctionUtils;

import java.util.Scanner;

public class DestinationService {

    public static void addDestinations() {
        DataPool.getDestinations().add(createDestination("TN", "MAA", "Chennai"));
        DataPool.getDestinations().add(createDestination("TN", "CBJ", "Coimbatore"));
        DataPool.getDestinations().add(createDestination("TN", "MRD", "Madurai"));
        DataPool.getDestinations().add(createDestination("TN", "TRZ", "Trichy"));
        DataPool.getDestinations().add(createDestination("KA", "BLR", "Bangalore"));
        DataPool.getDestinations().add(createDestination("KA", "MSR", "Mysore"));
        DataPool.getDestinations().add(createDestination("KL", "COK", "Cochin"));
        DataPool.getDestinations().add(createDestination("KL", "PLG", "Palakkad"));
        DataPool.getDestinations().add(createDestination("AP", "HYD", "Hyderabad"));
        DataPool.getDestinations().add(createDestination("AP", "SEC", "Seconderabad"));
    }

    public static Destination createDestination(String stateCode, String cityCode, String cityName) {
        for (String[] stateArray : DataHolder.states) {
            if (stateCode.equals(stateArray[0])) {
                return new Destination(addState(stateArray[0], stateArray[1]), new City(new ConfigCodes(cityCode, cityName)));
            }
        }
        return null;
    }

    public static State addState(String code, String name) {
        ConfigCodes stateConfig = new ConfigCodes(code, name);
        return new State(stateConfig);
    }

    public void listDestinations() {
        if (DataPool.getDestinations().isEmpty()) {
            FunctionUtils.displayMessage(DataHolder.ErrorMessage.NO_DATA_FOUND);
            return;
        }
        int[] columWidths = new int[4];
        int currentPage = 0;
        ConfigCodeService configCodeService = new ConfigCodeService();
        ConfigCodes pageConfig = configCodeService.getConfigCode(DataHolder.Pagination.PaginationConfig.PAGINATION_CONFIG_DESTINATION.name());
        int pageSize = pageConfig.getNumericValue().intValue();
        int totalPages  = (int) Math.ceil((double)DataPool.getDestinations().size() / pageConfig.getNumericValue().intValue()) ;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            FunctionUtils.displayMessage("\nPage " + (currentPage + 1) + " of " + totalPages );
            int start = currentPage * pageSize;
            int end = Math.min(start + pageSize, DataPool.getDestinations().size());
            String[] columnNames = new String[]{"State Code", "State Name", "City Code", "City Name"};

            for (int i = start; i < end; i++) {
                columWidths[0] = Math.max(columWidths[0], Math.max("State Code".length(), DataPool.getDestinations().get(i).getState().getConfigCode().getCode().length()));
                columWidths[1] = Math.max(columWidths[1], Math.max("State Name".length(), DataPool.getDestinations().get(i).getState().getConfigCode().getDescription().length()));
                columWidths[2] = Math.max(columWidths[2], Math.max("City Code".length(), DataPool.getDestinations().get(i).getCity().getConfigCode().getCode().length()));
                columWidths[3] = Math.max(columWidths[3], Math.max("City Name".length(), DataPool.getDestinations().get(i).getCity().getConfigCode().getDescription().length()));
            }
            FunctionUtils.printSeparator(columWidths);
            FunctionUtils.printRow(columWidths, columnNames);
            FunctionUtils.printSeparator(columWidths);
            for (int i = start; i < end; i++) {
                Destination destination = DataPool.getDestinations().get(i);
                FunctionUtils.printRow(columWidths, new String[]{destination.getState().getConfigCode().getCode(), destination.getState().getConfigCode().getDescription(),
                        destination.getCity().getConfigCode().getCode(), destination.getCity().getConfigCode().getDescription()});
            }

            FunctionUtils.printSeparator(columWidths);

            if(currentPage == 0){
                FunctionUtils.displayMessage(DataHolder.Pagination.PAGINATION_OPTION.replace("(P)revious,",""));
            }else if(currentPage >= (totalPages - 1)){
                FunctionUtils.displayMessage(DataHolder.Pagination.PAGINATION_OPTION.replace("(N)ext,",""));
            }else{
                FunctionUtils.displayMessage(DataHolder.Pagination.PAGINATION_OPTION);
            }
            String choice = scanner.nextLine().trim();
            if (choice.equalsIgnoreCase(DataHolder.Pagination.NEXT_FLAG) && currentPage < totalPages - 1) {
                currentPage++;
            } else if (choice.equalsIgnoreCase(DataHolder.Pagination.PREVIOUS_FLAG) && currentPage > 0) {
                currentPage--;
            } else if (choice.equalsIgnoreCase(DataHolder.Pagination.EXIT_FLAG)) {
                break;
            }
        }
    }

    public Destination getDestinationByStateCityCode(String stateCode, String cityCode) {
        for (Destination destination : DataPool.getDestinations()) {
            if (destination.getState().getConfigCode().getCode().equalsIgnoreCase(stateCode) && destination.getCity().getConfigCode().getCode().equalsIgnoreCase(cityCode)) {
                return destination;
            }
        }
        FunctionUtils.displayMessage(String.format("Destination not found for state code %s and city code %s", stateCode, cityCode));
        return null;
    }
}
