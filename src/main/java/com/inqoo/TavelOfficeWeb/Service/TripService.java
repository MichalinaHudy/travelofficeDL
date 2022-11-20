package com.inqoo.TavelOfficeWeb.Service;

import com.inqoo.TavelOfficeWeb.Model.Exception.NoTripByPriceFoundException;
import com.inqoo.TavelOfficeWeb.Model.Exception.NoTripByThisValue;
import com.inqoo.TavelOfficeWeb.Model.Trip;
import com.inqoo.TavelOfficeWeb.Repository.TripRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripService {
        @Autowired
        private TripRepo tripRepo;

        public void saveTrip(Trip trip) {
                tripRepo.saveTrip(trip);
        } // logikę biznesową

        public List<Trip> getAllCities(String tripFragment) {
                List<Trip> result = TripRepo.getAllTrips();
                if (tripFragment != null) {
                        result = result.stream()
                                .filter(c -> c.getDestination().contains(tripFragment))
                                .collect(Collectors.toList());
                }

                return result;

        }
        public List<Trip> getTripByValue(double rangeFrom,double rangeTo)throws NoTripByThisValue {
                List<Trip> tripsByValue = tripRepo.findTripsByPriceRange(rangeFrom, rangeTo);
                if (rangeFrom > rangeTo) {
                        throw new NoTripByThisValue("Podano zły zakres");
                }
        return tripsByValue;
        }


        public List<Trip> getTripByPrice (double rangeFrom, double rangeTo)throws NoTripByPriceFoundException  {
                List<Trip> tripsBYPrice = tripRepo.findTripsByPriceRange(rangeFrom,rangeTo);

                if(tripsBYPrice.isEmpty()) {
                throw new NoTripByPriceFoundException("brak wyników dla wyszukiwania " + rangeFrom + " i " + rangeTo);
        }

        return tripsBYPrice;
        }
}
