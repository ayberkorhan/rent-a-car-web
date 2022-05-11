package com.duzce.vtys.rentacar.repository;

import com.duzce.vtys.rentacar.model.EmployeeLogin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author mahmutcandurak
 */

public interface EmployeeLoginRepository extends JpaRepository<EmployeeLogin,Long> {
}
