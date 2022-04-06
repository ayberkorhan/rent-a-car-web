package com.duzce.vtys.rentacar.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class CustomerLoginDto implements Serializable {
    private final Long loginId;
    private final String email;
    private final String password;
    private final Date createdDate;

    public CustomerLoginDto(Long loginId, String email, String password, Date createdDate) {
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
        CustomerLoginDto entity = (CustomerLoginDto) o;
        return Objects.equals(this.loginId, entity.loginId) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.createdDate, entity.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loginId, email, password, createdDate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "loginId = " + loginId + ", " +
                "email = " + email + ", " +
                "password = " + password + ", " +
                "createdDate = " + createdDate + ")";
    }
}
