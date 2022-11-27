package com.inqoo.TavelOfficeWeb.Model;

import com.inqoo.TavelOfficeWeb.Trip;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
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

}
