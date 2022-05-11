package com.duzce.vtys.rentacar.service;

import com.duzce.vtys.rentacar.dto.EmployeeDto;
import com.duzce.vtys.rentacar.dto.EmployeeDtoConverter;
import com.duzce.vtys.rentacar.exception.EmployeeNotFoundException;
import com.duzce.vtys.rentacar.model.Employee;
import com.duzce.vtys.rentacar.model.EmployeeLogin;
import com.duzce.vtys.rentacar.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mahmutcandurak
 */

@Service
public class EmployeeService {


    private final EmployeeRepository employeeRepository;
    private final EmployeeDtoConverter employeeDtoConverter;
    private final EmployeeLoginService employeeLoginService;


    public EmployeeService(EmployeeRepository employeeRepository, EmployeeDtoConverter employeeDtoConverter, EmployeeLoginService employeeLoginService) {
        this.employeeRepository = employeeRepository;
        this.employeeDtoConverter = employeeDtoConverter;
        this.employeeLoginService = employeeLoginService;
    }

    public List<EmployeeDto> getAllEmployee() {
        return employeeDtoConverter.convert(employeeRepository.findAll());
    }

    protected Employee findEmployeeById(Long id) throws EmployeeNotFoundException {
        return employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException("Employee could not find by id: " + id.toString())
        );
    }

    public EmployeeDto getEmployeeById(Long id) throws EmployeeNotFoundException {
        return employeeDtoConverter.convert(
                employeeRepository.findById(id).orElseThrow(
                        ()-> new EmployeeNotFoundException(id.toString() + "Numaralı Çalışan Bulunamadı")
                )
        );
    }

    public EmployeeDto save (Employee employee) {
      EmployeeLogin employeeLogin = employeeLoginService.findEmployeeLoginById(employee.getEmployeeLogin().getLoginId());
      employee.setEmployeeLogin(employeeLogin);
      employeeRepository.save(employee);
      return employeeDtoConverter.convert(employee);

    }

    public EmployeeDto deleteEmployeeById(Long id) throws EmployeeNotFoundException {
        EmployeeDto employee = getEmployeeById(id);
        employeeRepository.deleteById(id);
        return employee;
    }

}
