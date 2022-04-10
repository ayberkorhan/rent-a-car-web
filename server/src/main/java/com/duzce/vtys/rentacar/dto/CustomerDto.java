package com.duzce.vtys.rentacar.dto;

import java.util.Date;
import java.util.Objects;

public class CustomerDto {


    private Long customerId;
    private Long loginId;
    private String firstName;
    private String lastName;
    private Long identityNumber;
    private Date birthday;
    private Date createdDate;

    public CustomerDto(Long customerId, Long customerLoginId, String firstName, String lastName, Long identityNumber) {}

    public CustomerDto(Long customerId, Long loginId, String firstName, String lastName, Long identityNumber, Date birthday, Date createdDate) {
        this.customerId = customerId;
        this.loginId = loginId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identityNumber = identityNumber;
        this.birthday = birthday;
        this.createdDate = createdDate;
    }

    public Long getCustomerId() {
        return customerId;
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

    public Long getIdentityNumber() {
        return identityNumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDto that = (CustomerDto) o;
        return Objects.equals(customerId, that.customerId) && Objects.equals(loginId, that.loginId) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(identityNumber, that.identityNumber) && Objects.equals(birthday, that.birthday) && Objects.equals(createdDate, that.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, loginId, firstName, lastName, identityNumber, birthday, createdDate);
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "customerId=" + customerId +
                ", loginId=" + loginId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", identityNumber=" + identityNumber +
                ", birthday=" + birthday +
                ", createdDate=" + createdDate +
                '}';
    }
}
