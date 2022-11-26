package com.inqoo.TavelOfficeWeb.Model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(name = "trip_start")
    public LocalDate start;
    @Column(name = "trip_end")
    public LocalDate end;
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
@Transient
    public double getPrice() {
        return priceEur;
    }
    @Transient
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
    @Transient
    public void setStart(LocalDate _start) {
        if (datesAreValid(_start, end)) {
            start = _start;
        }
     }
    @Transient
    public void setEnd(LocalDate _end) {
        if (datesAreValid(start, _end)) {
            end = _end;
        }
     }
    @Transient
    void printInfo() {
        System.out.println("Trip to "+destination+" starts on: "+start+" ends on: "+end+". Price is "+getPrice()+" EUR");
    }
    @Transient
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        Trip other = (Trip) o;
        return other.destination == destination;
    }
    @Transient
    public LocalDate getStart() {
        return start;
    }
    @Transient
    public LocalDate getEnd() {
        return end;
    }
    @Transient
    public String getDestination() {
        return destination;
    }
    @Transient
    public void setDestination(String destination) {
        this.destination = destination;
    }
    @Transient
    public void setPriceEur(double priceEur) {
        this.priceEur = priceEur;
    }
}
