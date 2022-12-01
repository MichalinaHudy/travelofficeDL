package com.inqoo.TavelOfficeWeb.Model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Embeddable;
import java.time.LocalDate;
@Data
@Embeddable
public class CustomerNameDetails  {
    @NotNull
    private  String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private int age;
    @NotNull
    private String pesel;
    @NotNull
    private String phone;

    public CustomerNameDetails() {

    }

    public CustomerNameDetails(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


}
