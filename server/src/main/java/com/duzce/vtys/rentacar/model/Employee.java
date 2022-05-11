package com.duzce.vtys.rentacar.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author mahmutcandurak
 */


@Entity
public class Employee implements Serializable {

    public Employee() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(name = "login_id")
    private Long loginId;

    private String firstName;

    private String lastName;

    private Date birthday;

    private String team;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "login_id", unique = true, insertable = false, updatable = false)
    private EmployeeLogin employeeLogin;


    @ManyToMany(cascade = {CascadeType.ALL})
            @JoinTable(
                    name = "Employee_And_Role",
                    joinColumns = {@JoinColumn(name = "employee_id" )},
                    inverseJoinColumns = {@JoinColumn(name = "role_id") }
            )
    Set<EmployeeRole> employeeRoleSet = new HashSet<>();


    //Getter and Setter Methods


    public EmployeeLogin getEmployeeLogin() {
        return employeeLogin;
    }

    public void setEmployeeLogin(EmployeeLogin employeeLogin) {
        this.employeeLogin = employeeLogin;
    }

    public Set<EmployeeRole> getEmployeeRoleSet() {
        return employeeRoleSet;
    }

    public void setEmployeeRoleSet(Set<EmployeeRole> employeeRoleSet) {
        this.employeeRoleSet = employeeRoleSet;
    }

    public Employee(EmployeeLogin employeeLogin) {
        this.employeeLogin = employeeLogin;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}


