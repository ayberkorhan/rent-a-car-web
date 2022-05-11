package com.duzce.vtys.rentacar.service;

import com.duzce.vtys.rentacar.dto.EmployeeLoginDto;
import com.duzce.vtys.rentacar.dto.EmployeeLoginDtoConverter;
import com.duzce.vtys.rentacar.exception.EmployeeLoginNotFoundException;
import com.duzce.vtys.rentacar.exception.EmployeeNotFoundException;
import com.duzce.vtys.rentacar.model.EmployeeLogin;
import com.duzce.vtys.rentacar.repository.EmployeeLoginRepository;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

/**
 * @author mahmutcandurak
 */

@Service
public class EmployeeLoginService {

    private final EmployeeLoginRepository employeeLoginRepository;
    private final EmployeeLoginDtoConverter employeeLoginDtoConverter;


    public EmployeeLoginService(EmployeeLoginRepository employeeLoginRepository, EmployeeLoginDtoConverter employeeLoginDtoConverter) {
        this.employeeLoginRepository = employeeLoginRepository;
        this.employeeLoginDtoConverter = employeeLoginDtoConverter;
    }

    public List<EmployeeLoginDto> getAllEmployeeLogin() {
        return new EmployeeLoginDtoConverter()
                .convert(employeeLoginRepository.findAll());
    }

    public EmployeeLoginDto save(EmployeeLogin employeeLogin) {
        return new EmployeeLoginDtoConverter()
                .convert(employeeLoginRepository.save(employeeLogin));
    }

    public EmployeeLoginDto getEmployeeLoginById(Long id) {
        return employeeLoginDtoConverter.convert(
                employeeLoginRepository.findById(id)
                .orElseThrow(() -> new EmployeeLoginNotFoundException("Employee Login could not find by id :" + id.toString()))
                );
    }

    public EmployeeLogin findEmployeeLoginById(Long id) {
        return employeeLoginRepository.findById(id)
                .orElseThrow(
                        () -> new EmployeeLoginNotFoundException("Employee Login could not find by id :" + id.toString())
                );
    }

    public EmployeeLogin deleteEmployeeLoginById(Long id) throws EmployeeLoginNotFoundException {
        EmployeeLogin employeeLogin = findEmployeeLoginById(id);
        employeeLoginRepository.deleteById(id);
        return employeeLogin;
    }

}


