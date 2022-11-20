package com.inqoo.TavelOfficeWeb.Repository;

import com.inqoo.TavelOfficeWeb.Model.Customer;
import com.inqoo.TavelOfficeWeb.Service.CustomerService;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepo {
    private List<CustomerService> Customer = new ArrayList<>(); // dane

    public static void saveCustomer(Customer customer) {
        Customer.add();
    } // logikę biznesową

    public List<Customer> getAllCities() {
        return saveCustomer();
    }
}
