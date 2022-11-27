package com.inqoo.TavelOfficeWeb.Service;

import com.inqoo.TavelOfficeWeb.Model.Customer;
import com.inqoo.TavelOfficeWeb.Repository.CustomerJpaRepository;
import com.inqoo.TavelOfficeWeb.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

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
        Customer exampleCity = Customer
                .builder()
                .firstnameLastname(firstLastNameFragment) // dokładne odwzorowanie - nie contains !
                .address(addressFragment) // dokładna liczba
                .build();

        return customerJpaRepository.findAll(Example.of(exampleCity));





    }

}
