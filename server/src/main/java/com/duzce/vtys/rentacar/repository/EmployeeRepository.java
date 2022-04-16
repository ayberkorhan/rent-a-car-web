package com.duzce.vtys.rentacar.repository;

import com.duzce.vtys.rentacar.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author mahmutcandurak
 */

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
