package com.inqoo.TavelOfficeWeb.Repository;

import com.inqoo.TavelOfficeWeb.Model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomerRepo {

    private static List<Customer> customers = new ArrayList<>(); // dane

    public static void saveCustomer(Customer customer) {
        customers.add(customer);
    } // logikę biznesową


    public List<Customer> getAllCustomers() { return customers;
    }


}
