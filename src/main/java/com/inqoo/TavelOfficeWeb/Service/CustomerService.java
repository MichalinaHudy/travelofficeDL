package com.inqoo.TavelOfficeWeb.Service;

import com.inqoo.TavelOfficeWeb.Model.Customer;
import com.inqoo.TavelOfficeWeb.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;
    public void saveCustomer(Customer customer) {customerRepo.saveCustomer(customer);
    }

    public List<Customer> getAllCustomers(String customersByFirstLastName) {
        List<Customer> result = CustomerRepo.getAllCustomers();
        if(customersByFirstLastName !=null){
            result = result.stream()
                    .filter(c->c.getFirstnameLastname().contains(customersByFirstLastName))
                    .collect(Collectors.toList());
        }
        return result;
    }

    public List<Customer>getAllCustomers2  (String customerByAddres){

    }
}


