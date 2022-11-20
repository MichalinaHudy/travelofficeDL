package com.inqoo.TavelOfficeWeb.Repository;

import com.inqoo.TavelOfficeWeb.Model.Trip;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Repository
public class TripRepo {

        private static List<Trip> trips = new ArrayList<>(); // dane

        public void saveTrip(Trip trip) {
            trips.add(trip);
        } // logikę biznesową

        public static List<Trip> getAllTrips() { return trips;}
        @PostConstruct

        public void createTrips() {
                Trip c1 = new Trip();
                c1.setDestination("oslo");
                c1.setEnd(LocalDate.of(2022, 12, 2));
                c1.setStart(LocalDate.of(2022, 11, 21));
                c1.setPriceEur(1400);

                Trip c2 = new Trip();
                c2.setDestination("Sosnowiec");
                c2.setEnd(LocalDate.of(2022, 12, 2));
                c2.setStart(LocalDate.of(2022, 11, 21));
                c2.setPriceEur(1400000);

                Trip c3 = new Trip();
                c3.setDestination("Londyn");
                c3.setEnd(LocalDate.of(2022, 12, 2));
                c3.setStart(LocalDate.of(2022, 11, 21));
                c3.setPriceEur(1000);

                trips.add(c1);
                trips.add(c2);
                trips.add(c3);
        }
}



