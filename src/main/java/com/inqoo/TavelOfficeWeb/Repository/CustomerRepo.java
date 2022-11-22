package com.inqoo.TavelOfficeWeb.Repository;

import com.inqoo.TavelOfficeWeb.Model.Customer;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CustomerRepo {

    private static List<Customer> customers = new ArrayList<>(); // dane

    public static void saveCustomer(Customer customer) {
        customers.add(customer);
    } // logikę biznesową


    public static List<Customer> getAllCustomers() { return customers;}
    public static List<Customer> getAllCustomersBYAddres() { return customers;}



    @PostConstruct
    public void createCustomer() {
        Customer cus1 = new Customer();
        cus1.setFirstnameLastname("Jan Kowalski");
        cus1.setAddress("Opole, ul. Niemodlińska 21");
//        cus1.setTrip(cus1.getTrip());
//        cus1.getTrip();
//        cus1.setTrip(Trip.c1);

        Customer cus2 = new Customer();
        cus2.setFirstnameLastname("Jan Nowak");
        cus2.setAddress("Opole, ul. Niemodlińska 22");

        Customer cus3 = new Customer();
        cus3.setFirstnameLastname("Jan Dąbrowski");
        cus3.setAddress("Opole, ul. Niemodlińska 23");

        Customer cus4 = new Customer();
        cus4.setFirstnameLastname("Jan Kowalski");
        cus4.setAddress("Opole, ul. Niemodlińska 21");

        customers.add(cus1);
        customers.add(cus2);
        customers.add(cus3);
        customers.add(cus4);

    }


}
