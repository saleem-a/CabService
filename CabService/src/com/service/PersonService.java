package com.service;

import com.constants.DataPool;
import com.model.Customer;
import com.model.Driver;
import com.model.Person;
import com.util.FunctionUtils;

import java.util.ArrayList;

public abstract class PersonService {

    public abstract void addPerson();

    public abstract void updateConfiguration(ConfigCodeService configCodeService);

    public void getPerson(String personType) {
        ArrayList<Person> persons = DataPool.getPersonDetails();
        if(persons.isEmpty()){
            FunctionUtils.displayMessage("No records found");
            return;
        }
        if (Driver.class.getSimpleName().equals(personType)) {
            FunctionUtils.displayMessage("Id \t Name \t Contact Number \t License \t Valid From \t Valid To");
        }else  if (Customer.class.getSimpleName().equals(personType)) {
            FunctionUtils.displayMessage("Id \t Name \t Contact Number");
        }
        for (Person person : persons) {
            if (Driver.class.getSimpleName().equals(personType)) {
                Driver driver = (Driver) person;
                FunctionUtils.displayMessage(driver.getPersonId()
                        + "\t" + driver.getName()
                        + "\t" + driver.getContact().getPrimaryNumber()
                        + "\t" + driver.getLicense().getNumber()
                        + "\t" + FunctionUtils.convertDateToString(driver.getLicense().getValidFrom())
                        + "\t" + FunctionUtils.convertDateToString(driver.getLicense().getValidTo()));
            } else if (Customer.class.getSimpleName().equals(personType)) {
                Customer driver = (Customer) person;
                FunctionUtils.displayMessage(driver.getPersonId()
                        + "\t" + driver.getName()
                        + "\t" + driver.getContact().getPrimaryNumber());
            }
        }
    }
}
