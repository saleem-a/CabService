package com.util;

import com.constants.DataHolder;
import com.model.ContactDetail;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public final class FunctionUtils {

    private FunctionUtils() {
    }

    public static void displayMessage(ArrayList<String> messages) {
        if (!messages.isEmpty())
            for (String message : messages)
                System.out.println(message);
    }

    public static void displayMessage(String message) {
        System.out.println(
                message);
    }

    public static String[] getStateConfig(String stateCode) {
        for (String[] states : DataHolder.states) {
            if (states[0].equalsIgnoreCase(stateCode))
                return states;
        }
        return new String[]{"DY", "DUMMY"};
    }

    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }

    public static String[] processData(String str) {
        return str.trim().split(",");
    }

    public static Date convertStringToDate(String dateStr) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException pex) {
            FunctionUtils.displayMessage(pex.getMessage());
        }
        return null;
    }

    public static String convertDateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }


    public static ContactDetail createContactDetails(String[] contactDetails) {
        if (contactDetails.length > 0) {
            return contactDetails.length == 1 ? new ContactDetail(contactDetails[0]) : new ContactDetail(contactDetails[0], contactDetails[1], contactDetails[2]);
        }
        return null;
    }

    public static void printSeparator(int[] columnWidths){
        for (int columnWidth : columnWidths) {
            System.out.print("+");
            System.out.print("-".repeat(columnWidth + 2));
        }
        System.out.println("+");
    }

    public static void printRow(int[] columWidths, String[] columnNames) {
       for(int i = 0; i < columWidths.length; i++) {
           System.out.printf("| %-"+(columWidths[i] + 1) +"s",columnNames[i]);
       }
        System.out.println("|");
    }
}
