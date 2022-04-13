package com.duzce.vtys.rentacar.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author mahmutcandurak
 */

@Entity
public class EmployeeLogin {

    public EmployeeLogin() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long loginId;

    @Column(unique = true)
    private String email;

    private String password;

    private Date createdDate;

    @OneToOne(mappedBy = "employeeLogin")
    private Employee employee;

    //Getter and Setter Methods

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
