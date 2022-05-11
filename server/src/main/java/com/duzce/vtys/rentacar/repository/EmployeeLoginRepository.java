package com.duzce.vtys.rentacar.repository;

import com.duzce.vtys.rentacar.model.EmployeeLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeLoginRepository extends JpaRepository<EmployeeLogin,Long> {
}
