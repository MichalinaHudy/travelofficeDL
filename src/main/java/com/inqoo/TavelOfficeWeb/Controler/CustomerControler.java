package com.inqoo.TavelOfficeWeb.Controler;


import com.inqoo.TavelOfficeWeb.Model.Customer;
import com.inqoo.TavelOfficeWeb.Service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class CustomerControler {
    @Autowired
    private CustomerService customerService;
//    @PostMapping(path = "/customers", consumes = "application/json")
//    public ResponseEntity createCustomer(@RequestBody Customer customer) {
//        customerService.saveCustomer(customer);
//        return ResponseEntity.created(null).build();
//    }

    @GetMapping(path = "/customers", produces = "application/json")
    public List<Customer> customers() {

        return customerService.getAllCustomers();
    }


    @GetMapping(path = "/customers/{customerId}", produces = "application/json")
    public Customer customerById(@PathVariable("customerId") Integer id) {

        return customerService.getAllCustomers().get(id);

    }

    @PostMapping(path = "/customers", consumes = "application/json")
    public ResponseEntity createNewTrip(@RequestBody Customer customer) {
        customerService.save(customer);

        URI savedCustomerId = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customer.getId())
                .toUri();
        // powinniśmy zwrócić URL właśnie zapisanego miasta
        return ResponseEntity.created(savedCustomerId).build();
    }
    @GetMapping(value = "/customers", produces = "application/json")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}