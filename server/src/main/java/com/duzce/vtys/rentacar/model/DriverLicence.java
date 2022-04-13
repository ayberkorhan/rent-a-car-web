package com.duzce.vtys.rentacar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity

public class DriverLicence implements Serializable {

    public DriverLicence(){}

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "licence_id")
    private Long driveLicenceId;

    private Date takenDate;
    private String licenceType;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Long getDriveLicenceId() {
        return driveLicenceId;
    }

    public void setDriveLicenceId(Long driveLicenceId) {
        this.driveLicenceId = driveLicenceId;
    }

    public Date getTakenDate() {
        return takenDate;
    }

    public void setTakenDate(Date takenDate) {
        this.takenDate = takenDate;
    }

    public String getLicenceType() {
        return licenceType;
    }

    public void setLicenceType(String licenceType) {
        this.licenceType = licenceType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
