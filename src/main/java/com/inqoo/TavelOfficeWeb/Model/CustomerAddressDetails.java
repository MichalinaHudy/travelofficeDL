package com.inqoo.TavelOfficeWeb.Model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class CustomerAddressDetails {
    private String Country;
    private String province;
    private String road;
    private String houseNumber;
    private String ZIPcode;

}
