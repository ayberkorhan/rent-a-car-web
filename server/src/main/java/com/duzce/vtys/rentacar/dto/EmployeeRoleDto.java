package com.duzce.vtys.rentacar.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author mahmutcandurak
 */

public class EmployeeRoleDto implements Serializable {

    private Long roleId;
    private String roleName;

    public EmployeeRoleDto(Long roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeRoleDto that = (EmployeeRoleDto) o;
        return roleId.equals(that.roleId) && Objects.equals(roleName, that.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName);
    }

    @Override
    public String toString() {
        return "EmployeeRoleDto{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
