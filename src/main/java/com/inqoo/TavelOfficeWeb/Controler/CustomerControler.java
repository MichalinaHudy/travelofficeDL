package com.inqoo.TavelOfficeWeb.Controler;

import com.inqoo.TavelOfficeWeb.Model.Customer;
import com.inqoo.TavelOfficeWeb.Model.CustomerNameDetails;
import com.inqoo.TavelOfficeWeb.Repository.CustomerJpaRepository;
import com.inqoo.TavelOfficeWeb.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class CustomerControler {
    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "/customers", produces = "application/json")
    public List<Customer> customers( @RequestParam(name="firstNameFragment", required = false) String firstNameFragment,
                                    @RequestParam(name="addressFragment", required = false) String addressFragment,
                                    @RequestParam(name="trip", required = false) Boolean trip){
        return customerService.getAllCustomers(firstNameFragment,addressFragment,trip);
    }


    @GetMapping(path = "/customers/{customerId}", produces = "application/json")
    public Customer customerById(@PathVariable("customerId") Integer id) {

        return customerService.getAllCustomers( null,null,null).get(id);

    }

    @PostMapping(path = "/customers", consumes = "application/json")
    public ResponseEntity createNewTrip(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        URI savedCustomerId = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customer.getId())
                .toUri();
        return ResponseEntity.created(savedCustomerId).build();
    }

//***************************    ćwiczę TOOO DOOO
//    @PatchMapping("/customers/{id}/{firstName}")
//    public ResponseEntity<Customer> updatePartCustomer(@PathVariable Long id, @PathVariable String firstName) {
//        try {
//            Customer customer= CustomerService.findById(id).get();
//            customer.setFirstName(firstName);
//            return new ResponseEntity<Customer>(Customerservice.save(customer), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }


}