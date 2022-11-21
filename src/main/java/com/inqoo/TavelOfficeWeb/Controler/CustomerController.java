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

    @GetMapping(path = "/customersByFirstLastName", produces = "application/json")
    public List<Customer> customers(@RequestParam(name = "customersByFirstLastName", required = false) String customersByFirstLastName) {
        System.out.println("Zapytanie o fragment iemienia nazwiska o wartosci: "+customersByFirstLastName);
        return customerService.getAllCustomers(customersByFirstLastName);
    }

    @GetMapping(path = "/customersByAddres", produces = "application/json")
    public List<Customer> customers2(@RequestParam(name = "customerByAddres",required = false)String customerByAddres){
        System.out.println("Wyniki wyszukiwania po adresie"+customerByAddres);
        return customerService.getAllCustomers(customerByAddres);

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