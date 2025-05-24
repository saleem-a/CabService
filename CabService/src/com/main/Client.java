package com.main;

import com.service.ConfigCodeService;
import com.service.DestinationService;
import com.service.MenuService;

public class Client {

    public static void main(String[] args) {
        init();
        MenuService menuService = new MenuService();
        menuService.showHomePage();
    }

    public static void init() {
        DestinationService.addDestinations();
        ConfigCodeService.addConfigCodes();
    }
}
