package com.duzce.vtys.rentacar.dto.employee;


import com.duzce.vtys.rentacar.model.Employee;
import org.springframework.stereotype.Component;


@Component
public class EmployeeDtoConverter {

    public EmployeeDto convert(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto(employee.getEmployeeId(),employee,employee.getFirstName(),employee.getLastName(),
                employee.getIdentityNumber(),employee.getAdress(),employee.getRole(),employee.getEmployeeLogin().getLoginId(),
                employee.getEmployeeLogin().getEmail(),employee.getEmployeeLogin().getPassword());
        return employeeDto;
    }

}
