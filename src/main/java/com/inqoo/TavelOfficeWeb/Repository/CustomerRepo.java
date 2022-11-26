package com.inqoo.TavelOfficeWeb.Repository;

import com.inqoo.TavelOfficeWeb.Model.Customer;
import com.inqoo.TavelOfficeWeb.Model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepo {

    public static List<Customer> getAllCustomers() { return customers;}
    private static List<Customer> customers = new ArrayList<>(); // dane


    public static void saveCustomer(Customer customer) {
        customers.add(customer);
    } // logikę biznesową
    @Autowired
    private TripRepo tripRepo;
    private Trip trip;
    private Trip trips;

    @PostConstruct
    public void createCustomer() {
//        List<Trip> allTrips = tripRepo.getAllTrips();
        Customer customer1 = new Customer();
        customer1.setFirstnameLastname("Jan Kowalski");
        customer1.setAddress("Opole, ul. Niemodlińska 21");
        customer1.setTrip(tripRepo.findByDestination("Sosnowiec"));
        //cus1.getTrip(tripRepo.createTrips(trip););
        //////////////////////dopisać wycieczkiiii!!!!!
        //cus1.setTrip(tripRepo.createTrips(););
        //customer1.getTrip(tripRepo.createTrips(trip););
    customer1.getTrip();
//
        Trip trip1 = new Trip();
        trip1.setDestination("oslo");
        trip1.setEnd(LocalDate.of(2022, 12, 2));
        trip1.setStart(LocalDate.of(2022, 11, 21));
        trip1.setPriceEur(1400);
        Customer cus2 = new Customer();
        cus2.setFirstnameLastname("Jan Nowak");
        cus2.setAddress("Opole, ul. Niemodlińska 22");
        cus2.setTrip(trip1);


        Customer cus3 = new Customer();
        cus3.setFirstnameLastname("Jan Dąbrowski");
        cus3.setAddress("Opole, ul. Niemodlińska 23");
        TripRepo tripRepo1 = new TripRepo();

//        cus3.getTrip(toString(tripRepo.createTrips(c3)));


        Customer cus4 = new Customer();
        cus4.setFirstnameLastname("Jan Kowalski");
        cus4.setAddress("Opole, ul. Niemodlińska 21");

        customers.add(customer1);
        customers.add(cus2);
        customers.add(cus3);
        customers.add(cus4);

    }


}
