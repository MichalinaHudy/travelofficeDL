package com.inqoo.TavelOfficeWeb.Service;

import com.inqoo.TavelOfficeWeb.Model.Customer;
import com.inqoo.TavelOfficeWeb.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;
    public void saveCustomer(Customer customer) {CustomerRepo.saveCustomer(customer);

        public List<Customer> getAllCustomers() { return Customer.getAllCustomers();
        }
    }
  }


