package com.duzce.vtys.rentacar.dto.employee;

import com.duzce.vtys.rentacar.model.Employee;

import java.io.Serializable;

public class EmployeeDto implements Serializable {

    public EmployeeDto(Long employeeId, Employee employee, String firstName, String lastName,
                       Long identityNumber, String adress, String role, Long loginId, String email,
                       String password) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identityNumber = identityNumber;
        this.adress = adress;
        this.role = role;
        this.loginId = loginId;
        this.email = email;
        this.password = password;
    }


    private Long employeeId;
    private String firstName;
    private String lastName;
    private Long identityNumber;
    private String adress;
    private String role;
    private Long loginId;
    private String email;
    private String password;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(Long identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
