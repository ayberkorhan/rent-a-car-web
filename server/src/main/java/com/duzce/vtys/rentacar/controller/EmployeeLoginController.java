package com.duzce.vtys.rentacar.controller;

import com.duzce.vtys.rentacar.dto.EmployeeLoginDto;
import com.duzce.vtys.rentacar.model.EmployeeLogin;
import com.duzce.vtys.rentacar.service.EmployeeLoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author mahmutcandurak
 */


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/employeelogin")
public class EmployeeLoginController {

    private final EmployeeLoginService employeeLoginService;


    public EmployeeLoginController(EmployeeLoginService employeeLoginService) {
        this.employeeLoginService = employeeLoginService;
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeLoginDto>> getAllEmployeeLogin() {
        return ResponseEntity.ok(employeeLoginService.getAllEmployeeLogin());
    }

    @PostMapping()
    public ResponseEntity<EmployeeLoginDto> postEmployeeLogin(@RequestBody EmployeeLogin employeeLogin) {
        return ResponseEntity.ok(employeeLoginService.save(employeeLogin));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeLogin> deleteEmployeeLogin(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(employeeLoginService.deleteEmployeeLoginById(id));
    }


    @GetMapping("/{id}")
    public ResponseEntity<EmployeeLoginDto> getAllEmployeeLogin(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(employeeLoginService.getEmployeeLoginById(id));
    }
}
