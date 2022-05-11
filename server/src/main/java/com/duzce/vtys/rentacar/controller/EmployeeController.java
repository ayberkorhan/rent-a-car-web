package com.duzce.vtys.rentacar.controller;

import com.duzce.vtys.rentacar.dto.employee.EmployeeDto;

import com.duzce.vtys.rentacar.dto.employee.EmployeeDtoConverter;
import com.duzce.vtys.rentacar.model.Employee;
import com.duzce.vtys.rentacar.model.EmployeeLogin;
import com.duzce.vtys.rentacar.service.EmployeeLoginService;
import com.duzce.vtys.rentacar.service.EmployeeService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeLoginService employeeLoginService;
    private final EmployeeDtoConverter converter;

    public EmployeeController(EmployeeService employeeService, EmployeeLoginService employeeLoginService, EmployeeDtoConverter converter) {
        this.employeeService = employeeService;
        this.employeeLoginService = employeeLoginService;
        this.converter = converter;
    }


    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeAndEmployeeLoginById(@PathVariable("id") Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        EmployeeDto dto = converter.convert(employee);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @JsonIgnore()
    public ResponseEntity<EmployeeDto> deleteEmployeeById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(employeeService.deleteEmployeeById(id));
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeDto>> getAllEmployeeWtihLogin() {
        List<Employee> employees = employeeService.getAllEmployee();
        List<EmployeeLogin> employeeLogins = employeeLoginService.getAllEmployeeLogin();
        List<EmployeeDto> employeeDtos = new ArrayList();
        employees.stream().forEach(emp -> {
            EmployeeDto dto = converter.convert(emp);
            employeeDtos.add(dto);
        });
        return ResponseEntity.ok(employeeDtos);
    }

    @PostMapping()
    @JsonIgnore
    public ResponseEntity<EmployeeDto> postEmployee(@RequestBody Employee employee){
        EmployeeDto employeeDto = converter.convert(employeeService.postEmployee(employee));
        return ResponseEntity.ok(employeeDto);
    }
}
