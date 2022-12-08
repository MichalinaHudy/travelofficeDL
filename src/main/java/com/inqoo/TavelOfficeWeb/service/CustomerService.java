package com.inqoo.TavelOfficeWeb.service;

import com.inqoo.TavelOfficeWeb.model.Customer;
import com.inqoo.TavelOfficeWeb.model.CustomerNameDetails;
import com.inqoo.TavelOfficeWeb.repository.CustomerJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    private static CustomerJpaRepository customerJpaRepository;

    public CustomerService(CustomerJpaRepository mockedCustomerRepository) {

    }


    public void saveCustomer(Customer customer) {
        customerJpaRepository.save(customer);
 }


//    public CustomerNameDetails getCustomerNameDetails() {
//        return customerNameDetails;
//    }

    public List<Customer> getAllCustomers(String firstNameFragment, String addressFragment, Boolean withoutAnyTrip) {
//        Customer cus1 = new Customer();
//        CustomerNameDetails cus2 = new CustomerNameDetails();
//        cus2.setFirstName(firstNameFragment);
//        cus1.setCustomerNameDetails(cus2);


        CustomerNameDetails details = CustomerNameDetails.builder().firstName(firstNameFragment).build();

        Customer exampleCustomer = Customer
                .builder()
                .customerNameDetails(details)
                .build();

        ExampleMatcher firstLastNameFragmentMatcher = ExampleMatcher
                .matchingAll()
                .withMatcher("address",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("Firstname", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        List<Customer> result = customerJpaRepository.findAll(Example.of(exampleCustomer, firstLastNameFragmentMatcher));
        if (withoutAnyTrip != null) {
            if (withoutAnyTrip) {
                result = result.stream()
                        .filter(e -> e.getTrips() == null || e.getTrips().isEmpty())
                        .collect(Collectors.toList());
            } else if (!withoutAnyTrip) {
                result = result.stream()
                        .filter(e -> e.getTrips() != null && !e.getTrips().isEmpty())
                        .collect(Collectors.toList());
            }
        }
        return result;

    }

}



