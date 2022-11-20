package com.inqoo.TavelOfficeWeb.Repository;

import com.inqoo.TavelOfficeWeb.Model.Trip;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class TripRepo {

        private List<Trip> trips = new ArrayList<>(); // dane

        public void saveTrip(Trip trip) {
            trips.add(trip);
        } // logikę biznesową

        public List<Trip> getAllTrips() {
            return trips;
        }
}
