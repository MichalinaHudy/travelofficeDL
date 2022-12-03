package com.inqoo.TavelOfficeWeb.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable @Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddressDetails {
    private String country;
    private String province;
    private String road;
    private String houseNumber;
    private String zipCode;

}
