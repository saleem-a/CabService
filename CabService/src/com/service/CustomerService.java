package com.service;

import com.constants.DataHolder;
import com.constants.DataPool;
import com.model.ConfigCodes;
import com.model.ContactDetail;
import com.model.Customer;
import com.model.Person;
import com.util.FunctionUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerService extends PersonService{

    @Override
    public void addPerson() {
        FunctionUtils.displayMessage(DataHolder.CommonConstant.DISPLAY_CUSTOMER_PROFILE_OPTION);
        Scanner scanner = new Scanner(System.in);
        String customerName = scanner.nextLine();
        String[] contact = FunctionUtils.processData(scanner.nextLine());
        ContactDetail contactDetail = FunctionUtils.createContactDetails(contact);
        if(contactDetail == null){
            FunctionUtils.displayMessage("Please provide valid contact details");
        }
        ConfigCodeService configCodeService = new ConfigCodeService();
        ConfigCodes configCode = configCodeService.getConfigCode(DataHolder.ProfileConfig.CUSTOMER_PROFILE.name());
        DataPool.getPersonDetails().add(new Customer(customerName, configCode.getNumericValue(), contactDetail));
        updateConfiguration(configCodeService);
        FunctionUtils.displayMessage(String.format("Customer profile created successfully for %s\n", customerName));
    }


    @Override
    public void updateConfiguration(ConfigCodeService configCodeService) {
        configCodeService.updateConfigCode(DataHolder.ProfileConfig.CUSTOMER_PROFILE.name());
    }

    public ArrayList<Customer> filterCustomer(String customerText){
        ArrayList<Customer> filteredCustomers= new ArrayList<>();

        for(Person person: DataPool.getPersonDetails()){
            if(person instanceof Customer &&
                    (person.getName().contains(customerText)
                            || String.valueOf(person.getPersonId()).equals(customerText))){
                filteredCustomers.add((Customer) person);
            }
        }
        return filteredCustomers;
    }
}
