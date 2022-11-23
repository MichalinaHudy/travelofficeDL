package com.inqoo.TavelOfficeWeb.Service;

import com.inqoo.TavelOfficeWeb.Model.Customer;
import com.inqoo.TavelOfficeWeb.Model.Exception.NoFirstLastNameExceptionFound;
import com.inqoo.TavelOfficeWeb.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public void saveCustomer(Customer customer) {
        customerRepo.saveCustomer(customer);
    }

    public List<Customer> getAllCustomers(String customersByFirstLastName, String customersByAddres, String customersWithNoTrip) throws NoFirstLastNameExceptionFound {
        List<Customer> result = CustomerRepo.getAllCustomers();
        if (customersByFirstLastName !=null) {
            result = result.stream()
                    .filter(c -> c.getFirstnameLastname().contains(customersByFirstLastName))
                    .collect(Collectors.toList());
            if (result.isEmpty()){
                throw new NoFirstLastNameExceptionFound("Brak wyników wyszukiwania dla podanego kryterium" + customersByFirstLastName);
            }
            if (customersByAddres !=null) {
                result = result.stream()
                        .filter(c -> c.getAddress().contains(customersByAddres))
                        .collect(Collectors.toList());
                if (customersWithNoTrip !=null) {
                    result = result.stream()
                            .filter(c -> c.getTrip().   //////////dokończyć filtrowanie !!!!
                            .collect(Collectors.toList());


        }


        return result;
    }

    public List<Customer> getAllCustomersBYAddres(String customerBYAddres) {
        List<Customer> result = CustomerRepo.getAllCustomersBYAddres();
        if (customerBYAddres != null) {
            result = result.stream()
                    .filter(c -> c.getAddress().contains(customerBYAddres))
                    .collect(Collectors.toList());
        }
        return result;

    }

}