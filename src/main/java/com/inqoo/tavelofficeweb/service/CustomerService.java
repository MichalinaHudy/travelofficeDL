package com.inqoo.tavelofficeweb.service;

import com.inqoo.tavelofficeweb.model.Customer;
import com.inqoo.tavelofficeweb.model.CustomerNameDetails;
import com.inqoo.tavelofficeweb.repository.CustomerJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service@RequiredArgsConstructor
public class CustomerService {

    private final CustomerJpaRepository customerJpaRepository;

    public void saveCustomer(Customer customer) {
        customerJpaRepository.save(customer);
 }
    public List<Customer> getAllCust() {
        return customerJpaRepository.findAll();
    }


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



