package com.service;

import com.constants.DataHolder;
import com.model.Customer;
import com.util.FunctionUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class CabBookingService {

    public void createBooking() {
        while (true) {
            FunctionUtils.displayMessage(DataHolder.CommonConstant.ENTER_CUSTOMER_NAME);
            Scanner scanner = new Scanner(System.in);
            String customerText = scanner.nextLine();
            ArrayList<Customer> customers = filterCustomer(customerText);
            if (customers.isEmpty()) {
                FunctionUtils.displayMessage(DataHolder.ErrorMessage.NO_DATA_FOUND);
                break;
            }
            listCustomers(customers);
            FunctionUtils.displayMessage(DataHolder.CommonConstant.ENTER_CUSTOMER_ID);
            Long customerId = scanner.nextLong();

        }
    }

    private ArrayList<Customer> filterCustomer(String customerText) {
        CustomerService customerService = new CustomerService();
        return customerService.filterCustomer(customerText);
    }

    private void listCustomers(ArrayList<Customer> customers) {
        FunctionUtils.displayMessage("Id \t Name \t Contact Number");
        for (Customer customer : customers) {
            FunctionUtils.displayMessage(String.format("%s\t%s\t%s", customer.getPersonId(), customer.getName(), customer.getContact().getPrimaryNumber()));
        }

    }
}
