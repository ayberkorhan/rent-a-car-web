package com.duzce.vtys.rentacar.dto;

import com.duzce.vtys.rentacar.model.Employee;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author mahmutcandurak
 */

public class EmployeeLoginDto implements Serializable {

    private Long loginId;
    private String email;
    private String password;
    private Date createdDate;

    public EmployeeLoginDto(Long loginId, String email, String password, Date createdDate) {
        this.loginId = loginId;
        this.email = email;
        this.password = password;
        this.createdDate = createdDate;
    }

    public Long getLoginId() {
        return loginId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeLoginDto that = (EmployeeLoginDto) o;
        return loginId.equals(that.loginId) && email.equals(that.email) && Objects.equals(password, that.password) && Objects.equals(createdDate, that.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loginId, email, password, createdDate);
    }

    @Override
    public String toString() {
        return "EmployeeLoginDto{" +
                "loginId=" + loginId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
