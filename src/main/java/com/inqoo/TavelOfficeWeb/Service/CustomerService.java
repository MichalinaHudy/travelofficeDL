package com.inqoo.TavelOfficeWeb.Service;


import com.inqoo.TavelOfficeWeb.Model.Customer;
import com.inqoo.TavelOfficeWeb.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public void saveCustomer(Customer customer) {
        customerRepository.saveCustmer(customer);
    } // logikę biznesową

    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    public void save(Customer customer) {
    }
}