package com.duzce.vtys.rentacar.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "customer_adress")
public class CustomerAdress implements Serializable {

    public CustomerAdress(){}

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long adressId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private String country;
    private String city;
    private String town;
    private String street;
    private String buildingInfo;
    private String doorNumber;
    private String zipCode;
    private Date createdDate;

    public Customer getCustomer() {
        return customer;
    }

    public Long getAdressId() {
        return adressId;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getTown() {return town;}

    public String getStreet() {
        return street;
    }

    public String getBuildingInfo() {
        return buildingInfo;
    }

    public String getDoorNumber() {
        return doorNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setBuildingInfo(String buildingInfo) {
        this.buildingInfo = buildingInfo;
    }

    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
