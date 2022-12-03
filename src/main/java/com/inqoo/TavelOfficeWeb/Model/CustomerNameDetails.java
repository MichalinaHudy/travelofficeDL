package com.inqoo.TavelOfficeWeb.Model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable @Builder
public class CustomerNameDetails  {
    private  String firstName;

    private String lastName;

    private int age;

    private String pesel;

    private String phone;


}
