package com.inqoo.TavelOfficeWeb.Controller;


import com.inqoo.TavelOfficeWeb.Model.Customer;
import com.inqoo.TavelOfficeWeb.Service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping(path = "/customers", consumes = "application/json")
    public ResponseEntity createCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return ResponseEntity.created(null).build();
    }

    @GetMapping(path = "/customers", produces = "application/json")
    public List<Customer> customers() {

        return customerService.getAllCustomers();
    }


    @GetMapping(path = "/customers/{customerId}", produces = "application/json")
    public Customer customerById(@PathVariable("customerId") Integer id) {

        return customerService.getAllCustomers().get(id);

    }

}