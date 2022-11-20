package com.inqoo.TavelOfficeWeb.Controler;

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
        System.out.println("Klientem jest: " + customer);
        customerService.saveCustomer(customer);
        return ResponseEntity.created(null).build();
    }

    @GetMapping(path = "/customers", produces = "application/json")
    public List<Customer> customers() {
//        Customer jankowalski = new Customer();
//        jankowalski.setFirstnameLastname("Jan Kowalski");
//        jankowalski.setAddress("Katowice");
//        Customer annakowal = new Customer();
//        annakowal.setFirstnameLastname("Anna Kowal");
//        annakowal.setAddress("Katowice");
//        return List.of(jankowalski, annakowal);
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "/customers/{customerId}", produces = "application/json")
    public Customer customerById(@PathVariable("customerId") Integer id) {
        Customer jankowalski = new Customer();
        jankowalski.setFirstnameLastname("Jan Kowalski");
        jankowalski.setAddress("Katowice");
        Customer annakowal = new Customer();
        annakowal.setFirstnameLastname("Anna Kowal");
        annakowal.setAddress("Katowice");
        return 1 == id ? jankowalski : annakowal;
    }

}