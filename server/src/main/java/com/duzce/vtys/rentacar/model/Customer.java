package com.duzce.vtys.rentacar.model;

import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "identity_number")
    private Long identityNumber;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cratedDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "login_id")
    private CustomerLogin customerLogin;

    public Long getCustomerID() {
        return customerId;
    }

    public void setCustomerID(Long customerID) {
        this.customerId = customerID;
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

    public Long getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(Long identityNumber) {
        this.identityNumber = identityNumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCratedDate() {
        return cratedDate;
    }

    public void setCratedDate(Date cratedDate) {
        this.cratedDate = cratedDate;
    }


}
