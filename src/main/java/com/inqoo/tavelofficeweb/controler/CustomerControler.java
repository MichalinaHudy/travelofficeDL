package com.inqoo.tavelofficeweb.controler;

import com.inqoo.tavelofficeweb.model.Customer;
import com.inqoo.tavelofficeweb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerControler {
    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "/", produces = "application/json")
    public List<Customer> customers( @RequestParam(name="firstNameFragment", required = false) String firstNameFragment,
                                    @RequestParam(name="addressFragment", required = false) String addressFragment,
                                    @RequestParam(name="trip", required = false) Boolean trip){
        return customerService.getAllCustomers(firstNameFragment,addressFragment,trip);
    }


    @GetMapping(path = "/{customerId}", produces = "application/json")
    public Customer customerById(@PathVariable("customerId") Integer id) {

        return customerService.getAllCustomers( null,null,null).get(id);

    }

    @PostMapping(path = "/", consumes = "application/json")
    public ResponseEntity createNewTrip(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        URI savedCustomerId = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customer.getId())
                .toUri();
        return ResponseEntity.created(savedCustomerId).build();
    }



}