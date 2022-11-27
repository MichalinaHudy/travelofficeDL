package com.inqoo.TavelOfficeWeb.Service;


import com.inqoo.TavelOfficeWeb.Model.Customer;
import com.inqoo.TavelOfficeWeb.Repository.CustomerJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerJpaRepository customerJpaRepository;

    public void saveCustomer(Customer customer) {customerJpaRepository.saveCustmer(customer);
    } // logikę biznesową

    public List<Customer> getAllCustomers() {
        return customerJpaRepository.getAllCustomers();
    }

    public void save(Customer customer) {
    }
}