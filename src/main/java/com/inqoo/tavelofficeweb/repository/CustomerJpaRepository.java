package com.inqoo.tavelofficeweb.repository;

import com.inqoo.tavelofficeweb.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CustomerJpaRepository extends JpaRepository<Customer,Integer>, JpaSpecificationExecutor<Customer> {




}
