package com.inqoo.TavelOfficeWeb.Model;

import com.inqoo.TavelOfficeWeb.Trip;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode

@Builder @NoArgsConstructor  @AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

   @OneToMany(cascade = CascadeType.PERSIST)
   @JoinColumn(name = "customer_id")
   private List<Trip> trips;

    @Embedded
    private CustomerAddressDetails customerAddressDetails;

    @Embedded
    private CustomerNameDetails customerNameDetails;
}
