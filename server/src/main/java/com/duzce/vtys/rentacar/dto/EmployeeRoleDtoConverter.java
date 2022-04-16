package com.duzce.vtys.rentacar.dto;

import com.duzce.vtys.rentacar.model.EmployeeRole;

import java.util.List;

/**
 * @author mahmutcandurak
 */

public class EmployeeRoleDtoConverter {

    public EmployeeRoleDto convert (EmployeeRole employeeRole) {
        return new EmployeeRoleDto(
                employeeRole.getRoleId(),
                employeeRole.getRoleName()
        );
    }
}
