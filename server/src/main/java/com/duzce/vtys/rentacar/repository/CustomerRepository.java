package com.duzce.vtys.rentacar.repository;

import com.duzce.vtys.rentacar.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
