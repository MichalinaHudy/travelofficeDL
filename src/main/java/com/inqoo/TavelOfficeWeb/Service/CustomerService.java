package com.inqoo.TavelOfficeWeb.Service;

import com.inqoo.TavelOfficeWeb.Model.Customer;
import com.inqoo.TavelOfficeWeb.Repository.CustomerJpaRepository;
import com.inqoo.TavelOfficeWeb.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    private CustomerJpaRepository customerJpaRepository;

    public void saveCustomer(Customer customer) {
        customerJpaRepository.save(customer);
    } // logikę biznesową

//    public List<Customer> getAllCustomers() {
//        return customerJpaRepository.findAll();
//    }

    public List<Customer> getAllCustomers(String firstLastNameFragment, String addressFragment, Boolean trip) {
        // 1 dokładne odwzorowanie, tj. where cos = parametr

        if (firstLastNameFragment != null || addressFragment != null) {
            Customer exampleCustomer = Customer.builder().build();
//                    .builder()
//                    .firstnameLastname(firstLastNameFragment) // dokładne odwzorowanie - nie contains !
//                    .address(addressFragment) // dokładna liczba
//                    .build();
//            return customerJpaRepository.findAll(Example.of(exampleCustomer));
            ExampleMatcher firstLastNameFragmentMatcher = ExampleMatcher
                    .matchingAll()
                    .withMatcher("address",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                    .withMatcher("firstnameLastname", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

            List<Customer> result = customerJpaRepository.findAll(Example.of(exampleCustomer, firstLastNameFragmentMatcher));
//        if (){
//            Customer exampleCustomer = Customer;
//            ExampleMatcher addressFragmentMatcher = ExampleMatcher
//                    .matchingAll()
//                    .withMatcher("address", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
//
//            customerJpaRepository.findAll(Example.of(exampleCustomer, addressFragmentMatcher));
//        }
            if (trip == true) {
                result = result.stream()
                        .filter(e -> e.getTrips() != null)
                        .collect(Collectors.toList());
            }
            return result;
        }
    return null;

    }

}



