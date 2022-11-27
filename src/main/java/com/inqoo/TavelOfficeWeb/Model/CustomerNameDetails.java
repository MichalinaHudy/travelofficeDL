package com.inqoo.TavelOfficeWeb.Model;

import lombok.Data;

import javax.persistence.Embeddable;
import java.time.LocalDate;
@Data
@Embeddable
public class CustomerNameDetails {

    public  String Firstname;
    private String Lastname;
    private int age;
    private LocalDate DateOfBirth;
    private String Pesel;

//    public void fnLn(){
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(Firstname);
//        stringBuilder.append(" ");
//        stringBuilder.append(Lastname);
//        String personalName = stringBuilder.toString();
//    }

}
