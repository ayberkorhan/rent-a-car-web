package com.duzce.vtys.rentacar.repository;

import com.duzce.vtys.rentacar.model.CustomerAdress;
import com.duzce.vtys.rentacar.model.EmployeeRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author mahmutcandurak
 */

public interface EmployeeRoleRepository extends JpaRepository<EmployeeRole, Long> {
    }
