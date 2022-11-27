package com.inqoo.TavelOfficeWeb.Model;

import com.inqoo.TavelOfficeWeb.Trip;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "firstlastname")
    private String firstnameLastname;
    @Column(name = "addres")
    private String address;

   @OneToMany(cascade = CascadeType.PERSIST)
   @JoinColumn(name = "customer_id")
   private List<Trip> trips;


    @Override
    public String toString() {
        return "Customer{" +
                "firstnameLastname='" + firstnameLastname + '\'' +
                ", address='" + address + '\'' +
                ", trip=" + (trips != null ? trips : "") +
                '}';
    }

//    void assignTrip(Trip _trip) { trips = trips; // argumentem jest wycieczka, którą chcę przypisać
//    }

//    void printInfo() {
//        System.out.println("Customer: "+firstnameLastname+", address: "+address);
//        if ( trips != null){
//            trips.printInfo(); // PROSZĘ obiekt klasy trip, żeby się przedstawił !
//        }
//    }

//    public int hashCode() {
//        return address.hashCode();
//    }
//    public boolean equals(Object o) {
//        Customer other = (Customer) o;
//        return other.address == address;
//    }

//    public String getFirstnameLastname() {
//        return firstnameLastname;
//    }
//
//    public void setFirstnameLastname(String firstnameLastname) {
//        this.firstnameLastname = firstnameLastname;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }

//    public List<Trip> getTrip() {
//        return trips;
//    }
//
//    public void setTrip(Trip trip) {
//        this.trips = Collections.singletonList(trip);
//    }
}
