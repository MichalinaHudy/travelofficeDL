package com.inqoo.TavelOfficeWeb.Service;

import com.inqoo.TavelOfficeWeb.Model.Customer;
import com.inqoo.TavelOfficeWeb.Repository.CustomerJpaRepository;
import com.inqoo.TavelOfficeWeb.Trip;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Customer> getAllCustomers() {
        return customerJpaRepository.findAll();
    }

    public List<Customer> getBY(String firstLastNameFragment, String addressFragment, boolean notrip) {
        if (firstLastNameFragment != null || addressFragment != null || notrip ==true) {
            return customerJpaRepository.findAllByFirstnameLastnameContains(firstLastNameFragment);
            }
//        if (addressFragment != null) {
//            return customerJpaRepository.findAllByAddressContains(addressFragment);
//            }
//            if (notrip ==true){
//                return customerJpaRepository.findAllByTripsIsNull(notrip);
//            }


        return customerJpaRepository.findAll();
    }



}