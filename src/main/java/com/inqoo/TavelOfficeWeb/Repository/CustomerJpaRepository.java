package com.inqoo.TavelOfficeWeb.Repository;

import com.inqoo.TavelOfficeWeb.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CustomerJpaRepository extends JpaRepository<Customer,Integer>, JpaSpecificationExecutor<Customer> {

//List<Customer>findAllByAddressContains(String addresFragment);
List<Customer>findAllByFirstnameLastnameContainsAndAddressContains(String firstLastNameFragment, String addresFragment);

//List<Customer>findAllByTripsIsNull(boolean notrip);
//

//


}
