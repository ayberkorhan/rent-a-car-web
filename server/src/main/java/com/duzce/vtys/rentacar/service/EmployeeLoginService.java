package com.duzce.vtys.rentacar.service;

import com.duzce.vtys.rentacar.exception.EmployeeLoginNotFoundException;
import com.duzce.vtys.rentacar.model.Employee;
import com.duzce.vtys.rentacar.model.EmployeeLogin;
import com.duzce.vtys.rentacar.repository.EmployeeLoginRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeLoginService {

    private final EmployeeLoginRepository employeeLoginRepository;

    public EmployeeLoginService(EmployeeLoginRepository employeeLoginRepository) {
        this.employeeLoginRepository = employeeLoginRepository;
    }


    public boolean login (EmployeeLogin employeeLogin){
        EmployeeLogin login = employeeLoginRepository.
                getEmployeeLoginByEmailAndPassword(employeeLogin.getEmail(),employeeLogin.getPassword());
        return login!=null;
    }
    public EmployeeLogin findEmployeeLoginById(Long id) {
        return employeeLoginRepository.findById(id)
                .orElseThrow(() -> new EmployeeLoginNotFoundException("Employee is not found by id:" + id.toString()));
    }

    public EmployeeLogin postEmployeeLogin(EmployeeLogin employeeLogin) {
        return employeeLoginRepository.save(employeeLogin);
    }

    public EmployeeLogin deleteEmployeeLogin(Long id) {
        EmployeeLogin employeeLogin = findEmployeeLoginById(id);
        if (employeeLogin != null) {
            employeeLoginRepository.deleteById(id);
            return employeeLogin;
        } else {
            throw new EmployeeLoginNotFoundException("Employee is not found by id:" + id.toString());
        }

    }

    public List<EmployeeLogin> getAllEmployeeLogin(){
        return employeeLoginRepository.findAll();
    }

}
