package com.duzce.vtys.rentacar.service;

import com.duzce.vtys.rentacar.dto.EmployeeRoleDto;
import com.duzce.vtys.rentacar.dto.EmployeeRoleDtoConverter;
import com.duzce.vtys.rentacar.model.Employee;
import com.duzce.vtys.rentacar.model.EmployeeRole;
import com.duzce.vtys.rentacar.repository.EmployeeRoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mahmutcandurak
 */

@Service
public class EmployeeRoleService {

    private final EmployeeService employeeService;
    private final EmployeeRoleRepository employeeRoleRepository;
    private final EmployeeRoleDtoConverter employeeRoleDtoConverter;
    private final EmployeeRole employeeRole;


    public EmployeeRoleService(EmployeeService employeeService, EmployeeRoleRepository employeeRoleRepository, EmployeeRoleDtoConverter employeeRoleDtoConverter, EmployeeRole employeeRole) {
        this.employeeService = employeeService;
        this.employeeRoleRepository = employeeRoleRepository;
        this.employeeRoleDtoConverter = employeeRoleDtoConverter;
        this.employeeRole = employeeRole;
    }


}
