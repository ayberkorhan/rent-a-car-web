package com.duzce.vtys.rentacar.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author mahmutcandurak
 */

@Entity
public class EmployeeRole {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long roleId;

    private String roleName;

    @OneToMany(mappedBy = "roleId")
    private List<EmployeeAndRole> employeeAndRoles;

    //Getter and Setter Methods

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<EmployeeAndRole> getEmployeeAndRoles() {
        return employeeAndRoles;
    }

    public void setEmployeeAndRoles(List<EmployeeAndRole> employeeAndRoles) {
        this.employeeAndRoles = employeeAndRoles;
    }
}
