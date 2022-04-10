package com.duzce.vtys.rentacar.dto;

import java.io.Serializable;
import java.util.Objects;

public class CustomerAdressDto implements Serializable {
    private final String country;
    private final String city;
    private final String town;
    private final String street;
    private final String buildingInfo;
    private final String doorNumber;
    private final String zipCode;
    private final Long customerId;
    private final Long adressId;



    public CustomerAdressDto(String country, String city, String town, String street, String buildingInfo,
                             String doorNumber, String zipCode, Long customerId, Long adressId) {
        this.country = country;
        this.city = city;
        this.town = town;
        this.street = street;
        this.buildingInfo = buildingInfo;
        this.doorNumber = doorNumber;
        this.zipCode = zipCode;
        this.customerId = customerId;
        this.adressId = adressId;
    }
    public Long getCustomerId() {
        return customerId;
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

    public String getTown() {
        return town;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerAdressDto entity = (CustomerAdressDto) o;
        return Objects.equals(this.country, entity.country) &&
                Objects.equals(this.city, entity.city) &&
                Objects.equals(this.town, entity.town) &&
                Objects.equals(this.street, entity.street) &&
                Objects.equals(this.buildingInfo, entity.buildingInfo) &&
                Objects.equals(this.doorNumber, entity.doorNumber) &&
                Objects.equals(this.zipCode, entity.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city, town, street, buildingInfo, doorNumber, zipCode);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "country = " + country + ", " +
                "city = " + city + ", " +
                "town = " + town + ", " +
                "street = " + street + ", " +
                "buildingInfo = " + buildingInfo + ", " +
                "doorNumber = " + doorNumber + ", " +
                "zipCode = " + zipCode + ")";
    }
}
