package com.duzce.vtys.rentacar.controller;

import com.duzce.vtys.rentacar.dto.EmployeeDto;
import com.duzce.vtys.rentacar.model.Employee;
import com.duzce.vtys.rentacar.service.EmployeeRoleService;
import com.duzce.vtys.rentacar.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author mahmutcandurak
 */


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService, EmployeeRoleService employeeRoleService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeDto>> getAllEmployee() throws Exception {
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeDto> deleteEmployeeById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(employeeService.deleteEmployeeById(id));
    }

    public ResponseEntity<EmployeeDto> createNewEmployee (@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.save(employee));
    }






}
