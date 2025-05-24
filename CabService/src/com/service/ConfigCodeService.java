package com.service;

import com.constants.DataHolder;
import com.constants.DataPool;
import com.model.ConfigCodes;

public class ConfigCodeService {

    public static void addConfigCodes() {
        createPaginationConfig();
        createProfileConfig();
    }

    public void updateConfigCode(String configType){
        for(ConfigCodes configCode: DataPool.getConfigCodes()){
            if(configCode.getCode().equals(configType)) {
                configCode.setNumericValue((configCode.getNumericValue() + 1 ));
            }
        }
    }

    public ConfigCodes getConfigCode(String configType){
        for(ConfigCodes configCode: DataPool.getConfigCodes()){
            if(configCode.getCode().equals(configType)) {
              return configCode;
            }
        }
        return null;
    }

    public static void createProfileConfig(){
        DataPool.getConfigCodes().add(new ConfigCodes(DataHolder.ProfileConfig.DRIVER_PROFILE.name(), null, 1000L));
        DataPool.getConfigCodes().add(new ConfigCodes(DataHolder.ProfileConfig.CUSTOMER_PROFILE.name(), null, 4000L));
    }

    public static void createPaginationConfig(){
        ConfigCodes destinationConfig = new ConfigCodes(DataHolder.Pagination.PaginationConfig.PAGINATION_CONFIG_DESTINATION.name(), null , 5L);
        DataPool.getConfigCodes().add(destinationConfig);
    }
}
