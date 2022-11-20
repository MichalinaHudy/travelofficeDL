package com.inqoo.TavelOfficeWeb.Service;

import com.inqoo.TavelOfficeWeb.Model.Trip;
import com.inqoo.TavelOfficeWeb.Repository.TripRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TripService {
        @Autowired
        private TripRepo tripRepo;
        public void saveTrip(Trip trip) {
            tripRepo.saveTrip(trip);
        } // logikę biznesową

        public List<Trip> getAllCities() { return tripRepo.getAllTrips();
        }
}
