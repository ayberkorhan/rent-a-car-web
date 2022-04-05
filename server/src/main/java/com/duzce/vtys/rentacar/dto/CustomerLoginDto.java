package com.duzce.vtys.rentacar.dto;

import com.duzce.vtys.rentacar.repository.CustomerLoginRepository;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class CustomerLoginDto implements Serializable {
    private final String email;
    private final String password;
    private final Date createdDate;


    public CustomerLoginDto(String email, String password, Date createdDate) {
        this.email = email;
        this.password = password;
        this.createdDate = createdDate;
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
        return Objects.equals(this.email, entity.email) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.createdDate, entity.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, createdDate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "email = " + email + ", " +
                "password = " + password + ", " +
                "createdDate = " + createdDate + ")";
    }
}
