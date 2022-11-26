package com.inqoo.TavelOfficeWeb.Model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(name = "trip_start")
    private LocalDate start;
    @Column(name = "trip_end")
    private LocalDate end;
    @Column(name = "trip_destination",length = 40)
    private String destination;
    @Column(name = "price_eur")
    private double priceEur;

    @Override
    public String toString() {
        return "Trip{" +
                "start=" + start +
                ", end=" + end +
                ", destination='" + destination + '\'' +
                ", priceEur=" + priceEur +
                '}';
    }

    public double getPrice() {
        return priceEur;
    }
    private boolean datesAreValid(LocalDate _start, LocalDate _end) {
        if (_end != null) {
            if (_start != null) {
                if (_start.isAfter(_end)) {
                    System.out.println("Data rozpoczęcia nie może być po dacie zakończenia");
                    return false;
                }
            }
        }
        return true;
    }

    public void setStart(LocalDate _start) {
        if (datesAreValid(_start, end)) {
            start = _start;
        }
     }
    public void setEnd(LocalDate _end) {
        if (datesAreValid(start, _end)) {
            end = _end;
        }
     }

    void printInfo() {
        System.out.println("Trip to "+destination+" starts on: "+start+" ends on: "+end+". Price is "+getPrice()+" EUR");
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        Trip other = (Trip) o;
        return other.destination == destination;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setPriceEur(double priceEur) {
        this.priceEur = priceEur;
    }
}
