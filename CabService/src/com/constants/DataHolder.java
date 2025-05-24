package com.constants;

import java.util.ArrayList;

public final class DataHolder {

    private DataHolder(){}

    public static final ArrayList<String[]> states = new ArrayList<>();

    public enum ProfileConfig {
        DRIVER_PROFILE, CUSTOMER_PROFILE
    }

    static{
        states.add(new String[]{"TN", "Tamil Nadu"});
        states.add(new String[]{"KL", "Kerala"});
        states.add(new String[]{"KA", "Karnataka"});
        states.add(new String[]{"TG", "Telugana"});
        states.add(new String[]{"AP", "Andra Pradesh"});
    }

    public enum VehicleBrand {
        HONDA("HA"),
        BENZ("BZ"),
        BMW("BW"),
        AUDI("AD"),
        HYUNDAI("HD");

        private String code;

        VehicleBrand(String code){
            this.code = code;
        }

        public String getCode(){
            return this.code;
        }
    }

    public enum VehicleClass {
        LUXURY("L"), ECONOMIC("E");

        private String code;

        VehicleClass(String code){
            this.code = code;
        }

        public String getCode(){
            return this.code;
        }
    }

    public enum VehicleType {

        SEDAN("S"), SUV("U"), COMPACT("C");

        private String code;

        VehicleType(String code){
            this.code = code;
        }

        public String getCode(){
            return this.code;
        }
    }

    public static final class ErrorMessage {
        public static final String INVALID_VEHICLE_CLASS = "Please enter valid vehicle class (L/E)";
        public static final String INVALID_VEHICLE_TYPE = "Please enter valid vehicle type (S/U/C)";
        public static final String INVALID_VEHICLE_BRAND = "Please enter valid vehicle brand";
        public static final String INVALID_STATE_CODE = "Please enter valid state code";
        public static final String INVALID_VEHICLE_PLATE = "Please enter valid plate number (00-A-0000)";

        public static final String NO_DATA_FOUND = "No result found";
    }

    public static final class SuccessMessage {
        public static final String RECORD_CREATE_SUCCESSFULLY = "Record created successfully!!!!";
    }

    public static final class CommonConstant {
        public static final String DISPLAY_VEHICLE_INFO = """
            Enter vehicle information
                1. Class ->
                    LUXURY(L)
                    ECONOMY(E)
                2. Type ->
                    SEDAN(S)
                    SUV(U)
                    COMPACT(C)
                3. Brand ->
                    HONDA(HA)
                    BENZ(BZ)
                    BMW(BW)
                    AUDI(AD)
                    HYUNDAI(HD)
                4. REGISTRATION ->
                    TAMIL NADU(TN)
                    KERALA(KL)
                    KARNATAKA(TA)
                    ANDRA PRADESH(AP)
                    TELANGANA(TG)
                5. PLATE CODE & NUMBER ->
                    Provide valid plate code & number""";
        
        public static final String DISPLAY_MAIN_MENU = """
                1. Vehicle ->
                    List all Vehicles (LV)
                    Add Vehicles (AV)
                2. Profile ->
                    Driver (DL)
                    Customer (CL)
                    Add Driver (AD)
                    Add Customer (AC)
                3. Booking ->
                    List (BL)
                    Create Booking (CB)
                    Amend Booking (AB)
                    Cancel Booking (DB)
                4. Routes ->
                    List Destinations (DS)
                    List (RL)
                    Create Route(CR)
                5. Quit ->
                    Qq
                """;
        public static final String QUIT_OPTION = "Qq";

        public static final String DISPLAY_USER_ACTION = """
            1. Home (Hh)
            2. Quit (Qq)
        """;

        public static final String DISPLAY_ROUTE_OPTION = """
                1. From Location (State code ,City code)
                2. To Location (State code ,City code)
                """;

        public static final String DISPLAY_DRIVER_PROFILE_OPTION = """ 
                1. Driver Name
                2. Contact Detail (Primary Number ,Email Id, Alternative Number)
                3. Licence (Id, Valid From, Valid To)
                """;
        public static final String DISPLAY_CUSTOMER_PROFILE_OPTION = """ 
                1. Customer Name
                2. Contact Detail (Primary Number ,Email Id, Alternative Number)
                """;

        public static final String ENTER_CUSTOMER_NAME = "Enter Customer Name or Number";
        public static final String ENTER_CUSTOMER_ID = "Enter the customer ID to proceed";
    }

    public static final class Pagination {
        public static final String PAGINATION_OPTION = "(N)ext, (P)revious, (E)xit";
        public static final String NEXT_FLAG = "N";
        public static final String PREVIOUS_FLAG = "P";
        public static final String EXIT_FLAG = "E";

        public enum PaginationConfig{
            PAGINATION_CONFIG_DESTINATION, PAGINATION_CONFIG_DRIVER , PAGINATION_CONFIG_CUSTOMER
        }

    }
}
