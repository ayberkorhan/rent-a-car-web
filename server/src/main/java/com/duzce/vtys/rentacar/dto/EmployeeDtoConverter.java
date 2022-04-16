package com.duzce.vtys.rentacar.dto;

import com.duzce.vtys.rentacar.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mahmutcandurak
 */

@Component
public class EmployeeDtoConverter {

    public List<EmployeeDto> convert(List<Employee> employees) {

        return employees.stream()
                .map(emp -> new EmployeeDto(
                        emp.getEmployeeId(),
                        emp.getLoginId(),
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getBirthday(),
                        emp.getTeam()))
                .collect(Collectors.toList());

    }

    public EmployeeDto convert(Employee employee) {
        return new EmployeeDto(employee.getEmployeeId(),
                employee.getLoginId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getBirthday(),
                employee.getTeam());
    }
}
