package com.duzce.vtys.rentacar.dto;

import com.duzce.vtys.rentacar.model.EmployeeRole;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author mahmutcandurak
 */

@Component
public class EmployeeRoleDtoConverter {

    public EmployeeRoleDto convert (EmployeeRole employeeRole) {
        return new EmployeeRoleDto(
                employeeRole.getRoleId(),
                employeeRole.getRoleName()
        );
    }
}
