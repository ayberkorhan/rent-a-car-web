package com.duzce.vtys.rentacar.dto;

import com.duzce.vtys.rentacar.model.EmployeeLogin;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mahmutcandurak
 */

@Component
public class EmployeeLoginDtoConverter {

    public List<EmployeeLoginDto> convert (List<EmployeeLogin> employeeLogins) {

        return employeeLogins.stream()
                .map(employeeLogin -> new EmployeeLoginDto(
                        employeeLogin.getLoginId(),
                        employeeLogin.getEmail(),
                        employeeLogin.getPassword(),
                        employeeLogin.getCreatedDate()))
                .collect(Collectors.toList());
    }

    public EmployeeLoginDto convert (EmployeeLogin employeeLogin) {
        return new EmployeeLoginDto(employeeLogin.getLoginId(),
                employeeLogin.getEmail(),
                employeeLogin.getPassword(),
                employeeLogin.getCreatedDate());
    }

}
