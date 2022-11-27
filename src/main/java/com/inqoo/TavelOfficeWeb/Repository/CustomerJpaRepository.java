package com.inqoo.TavelOfficeWeb.Repository;

import com.inqoo.TavelOfficeWeb.Model.Customer;
import com.inqoo.TavelOfficeWeb.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerJpaRepository extends JpaRepository<Trip,Integer> {

    void saveCustmer(Customer customer);

    List<Customer> getAllCustomers();
}
