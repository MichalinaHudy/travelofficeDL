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

    public List<Customer> getBY(String firstLastNameFragment, String addressFragment, boolean trip) {
        if (firstLastNameFragment != null) {
            return customerJpaRepository.findAllByFirstnameLastname(firstLastNameFragment);
        }
            if (addressFragment != null) {
                return customerJpaRepository.findAllByAddress(addressFragment);
            }
//            if (trip == null){
//                return customerJpaRepository.findAllByAddress(addressFragment);
//            }


        return customerJpaRepository.findAll();
    }



}