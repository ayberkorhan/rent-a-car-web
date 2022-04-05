package com.duzce.vtys.rentacar.repository;

import com.duzce.vtys.rentacar.model.CustomerLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerLoginRepository extends JpaRepository<CustomerLogin,Long> {
}
