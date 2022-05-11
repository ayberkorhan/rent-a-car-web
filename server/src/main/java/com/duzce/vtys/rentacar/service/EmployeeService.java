package com.duzce.vtys.rentacar.service;


import com.duzce.vtys.rentacar.dto.employee.EmployeeDto;
import com.duzce.vtys.rentacar.dto.employee.EmployeeDtoConverter;
import com.duzce.vtys.rentacar.exception.EmployeeLoginNotFoundException;
import com.duzce.vtys.rentacar.model.Employee;
import com.duzce.vtys.rentacar.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeLoginService loginService;
    private final EmployeeDtoConverter converter;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeLoginService loginService, EmployeeDtoConverter converter) {
        this.employeeRepository = employeeRepository;
        this.loginService = loginService;
        this.converter = converter;
    }

    protected Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeLoginNotFoundException("Employee not found by id:" + id.toString()));
    }

    public Employee getEmployeeById(Long id) {
        return findEmployeeById(id);
    }

    @Transactional
    public Employee postEmployee(Employee employee) {
        employee.setEmployeeLogin(loginService.postEmployeeLogin(employee.getEmployeeLogin()));
        return employeeRepository.save(employee);
    }


    @Transactional
    public EmployeeDto deleteEmployeeById(Long id) {
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            EmployeeDto dto = converter.convert(employee);
            employeeRepository.deleteById(id);
            return dto;
        } else {
            throw new EmployeeLoginNotFoundException("Employee not found by id:" + id.toString());
        }
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }


}
