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

    @SuppressWarnings("JpaModelReferenceInspection") //// ukrycie wad..... do poprawy ale puki co działa...
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "firstName", column = @Column(name = "first_name")),
            @AttributeOverride( name = "LastName", column = @Column(name = "last_name")),
            @AttributeOverride( name = "Age", column = @Column(name = "age")),
            @AttributeOverride( name = "DateOfBirth", column = @Column(name = "date_of_birth")),
            @AttributeOverride( name = "Pesel", column = @Column(name = "pesel")),
            @AttributeOverride( name = "Phone", column = @Column(name = "contact_phone"))
    })
    private CustomerNameDetails customerNameDetails;
}
