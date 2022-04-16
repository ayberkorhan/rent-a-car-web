package com.duzce.vtys.rentacar.dto;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author mahmutcandurak
 */

public class EmployeeDto implements Serializable {

    private Long employeeId;
    private Long loginId;
    private String firstName;
    private String lastName;
    private Date birthday;
    private String team;


    public EmployeeDto(Long employeeId, Long loginId, String firstName, String lastName, Date birthday, String team) {
        this.employeeId = employeeId;
        this.loginId = loginId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.team = team;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public Long getLoginId() {
        return loginId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDto that = (EmployeeDto) o;
        return employeeId.equals(that.employeeId) && loginId.equals(that.loginId) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(birthday, that.birthday) && Objects.equals(team, that.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, loginId, firstName, lastName, birthday, team);
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "employeeId=" + employeeId +
                ", loginId=" + loginId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", team='" + team + '\'' +
                '}';
    }
}
