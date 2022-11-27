package com.inqoo.TavelOfficeWeb.Model;

import com.inqoo.TavelOfficeWeb.Trip;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "firstlastname")
    private String firstnameLastname;
    @Column(name = "addres")
    private String address;
    @Column(name = "trip_start")
//   @OneToMany(cascade = CascadeType.PERSIST)
//   @JoinColumn(name = "trip_id")
//   private List<Trip> trips;


    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "trips_id")
    private Trip trip;

    @Override
    public String toString() {
        return "Customer{" +
                "firstnameLastname='" + firstnameLastname + '\'' +
                ", address='" + address + '\'' +
                ", trip=" + (trip != null ? trip : "") +
                '}';
    }

    // metoda do przypisania wycieczki do klienta
    // użycie metody do przypisania daje możliwości np walidacji
    void assignTrip(Trip _trip) { // argumentem jest wycieczka, którą chcę przypisać
        trip = _trip;
    }

    void printInfo() {
        System.out.println("Customer: "+firstnameLastname+", address: "+address);
        if ( trip != null){
            trip.printInfo(); // PROSZĘ obiekt klasy trip, żeby się przedstawił !
        }
    }

    public int hashCode() {
        return address.hashCode();
    }
    public boolean equals(Object o) {
        Customer other = (Customer) o;
        return other.address == address;
    }

    public String getFirstnameLastname() {
        return firstnameLastname;
    }

    public void setFirstnameLastname(String firstnameLastname) {
        this.firstnameLastname = firstnameLastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}
