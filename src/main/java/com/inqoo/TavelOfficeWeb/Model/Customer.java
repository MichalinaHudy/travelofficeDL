package com.inqoo.TavelOfficeWeb.Model;


import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Builder @AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id")
    private List<Trip> trips;

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


    @Embedded
    private CustomerNameDetails customerNameDetails = new CustomerNameDetails();
//    @AttributeOverrides({
//            @AttributeOverride(name = "firstname", column = @Column(name = "first_name")),
//            @AttributeOverride(name = "lastname", column = @Column(name = "last_name")),
//            @AttributeOverride(name = "age", column = @Column(name = "age")),
//            @AttributeOverride(name = "dateOfBirth", column = @Column(name = "date_of_birth")),
//            @AttributeOverride(name = "pesel", column = @Column(name = "pesel")),
//            @AttributeOverride(name = "phone", column = @Column(name = "contact_phone"))
//    })
////    @Embedded
//    private CustomerAddressDetails customerAddressDetails;

//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "country", column = @Column(name = "country")),
//            @AttributeOverride(name = "province", column = @Column(name = "province")),
//            @AttributeOverride(name = "road", column = @Column(name = "road")),
//            @AttributeOverride(name = "houseNumber", column = @Column(name = "house_number")),
//            @AttributeOverride(name = "zipCode", column = @Column(name = "zip_code"))
//    })




    }
