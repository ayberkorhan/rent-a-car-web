package com.duzce.vtys.rentacar.model;

import javax.persistence.*;

/**
 * @author mahmutcandurak
 */


@Entity
public class EmployeeAndRole {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long employeeRoleId;

    private Long employeeId;

    private Long roleId;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private EmployeeRole employeeRole;


    //Getter and Setter Methods

    public Long getEmployeeRoleId() {
        return employeeRoleId;
    }

    public void setEmployeeRoleId(Long employeeRoleId) {
        this.employeeRoleId = employeeRoleId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public EmployeeRole getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(EmployeeRole employeeRole) {
        this.employeeRole = employeeRole;
    }
}

