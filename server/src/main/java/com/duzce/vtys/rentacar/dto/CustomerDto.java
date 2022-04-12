package com.duzce.vtys.rentacar.dto;


import java.io.Serializable;
import java.util.Objects;


public class CustomerDto implements Serializable {


    private Long customerId;
    private Long loginId;
    private String firstName;
    private String lastName;
    private Long identityNumber;


    public CustomerDto(Long customerId, String firstName, String lastName, Long identityNumber,Long loginId) {
        this.customerId = customerId;
        this.loginId = loginId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identityNumber = identityNumber;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDto that = (CustomerDto) o;
        return Objects.equals(customerId, that.customerId) && Objects.equals(loginId, that.loginId) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(identityNumber, that.identityNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, loginId, firstName, lastName, identityNumber);
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "customerId=" + customerId +
                ", loginId=" + loginId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", identityNumber=" + identityNumber +
                '}';
    }
}
