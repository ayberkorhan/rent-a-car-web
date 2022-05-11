package com.duzce.vtys.rentacar.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class EmployeeLogin implements Serializable {

    public EmployeeLogin(){}

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long loginId;

    @Column(unique = true)
    private String email;

    @Column(name = "login_password")
    private String password;

    @OneToOne(mappedBy = "employeeLogin",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Employee employee;

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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
