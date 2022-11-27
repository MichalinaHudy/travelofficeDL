package com.inqoo.TavelOfficeWeb.Repository;

import com.inqoo.TavelOfficeWeb.Model.Customer;
import com.inqoo.TavelOfficeWeb.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerJpaRepository extends JpaRepository<Customer,Integer> {

//List<Customer>findAllByAddressContains(String addresFragment);
List<Customer>findAllByFirstnameLastnameContainsAndAddressContainsAndTripsIsNull(String firstLastNameFragment,String addresFragment,boolean trip);

//List<Customer>findAllByTripsIsNull(boolean notrip);


//


}
