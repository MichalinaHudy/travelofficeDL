package com.inqoo.TavelOfficeWeb.repository;

import com.inqoo.TavelOfficeWeb.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CustomerJpaRepository extends JpaRepository<Customer,Integer>, JpaSpecificationExecutor<Customer> {




}
