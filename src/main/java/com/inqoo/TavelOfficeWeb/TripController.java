package com.inqoo.TavelOfficeWeb;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class TripController {
    @PostMapping(path ="/trips", consumes = "application/json")
    public ResponseEntity createCity(@RequestBody Trip trip){
        System.out.println("Wycieczka do: "+ trip);
        return ResponseEntity.created(null).build();
}
    @GetMapping(path = "/trips", produces = "application/json")
    public List<Trip> trips(){
        Trip warszawa = new Trip();
        warszawa.setDestination("warszawa");
        warszawa.setEnd(LocalDate.of(2022,12,2));
        warszawa.setStart(LocalDate.of(2022,11,21));
        warszawa.setPriceEur(700);

        Trip krakow = new Trip();
        krakow.setDestination("kraków");
        krakow.setPriceEur(1500);
        krakow.setStart(LocalDate.of(2022, 12, 30));
        krakow.setEnd(LocalDate.of(2023,01,07));
        return List.of(warszawa,krakow);
    }
    @GetMapping(path = "/trips/{tripId}", produces = "application/json")
    public Trip tripsById(@PathVariable("tripId") Integer id){
        Trip warszawa = new Trip();
        warszawa.setDestination("warszawa");
        warszawa.setEnd(LocalDate.of(2022,12,2));
        warszawa.setStart(LocalDate.of(2022,11,21));
        warszawa.setPriceEur(700);

        Trip krakow = new Trip();
        krakow.setDestination("kraków");
        krakow.setPriceEur(1500);
        krakow.setStart(LocalDate.of(2022, 12, 30));
        krakow.setEnd(LocalDate.of(2023,01,07));
        return 1==id ? warszawa:krakow;
}}

