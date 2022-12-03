package com.inqoo.TavelOfficeWeb.Model;

import lombok.*;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/*
    Ta klasa ma:
    - przechowywać informacje o wycieczce (zakres i typy wg opisu)
    - udostępniać możliwość wyświetlania informacji o wycieczce
 */
@Entity
@Getter
@Setter
@ToString

@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Audited
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "trip_start")
    private LocalDate start;
    @Column(name = "trip_end")
    private LocalDate end;
    @Column(name = "destination")
    private String destination;
    @Column(name = "price_eur")
    private double priceEur;


    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    // kolumny audytowe
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdOn;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime modifiedOn;







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
    void setStart(LocalDate _start) {
        if (datesAreValid(_start, end)) {
            start = _start;
        }
    }
    void setEnd(LocalDate _end) {
        if (datesAreValid(start, _end)) {
            end = _end;
        }
    }
    public void printInfo() {
        System.out.println("Trip to "+destination+" starts on: "+start+" ends on: "+end+". Price is "+getPriceEur()+" EUR");
    }
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        Trip other = (Trip) o;
        return other.destination == destination;
    }
}