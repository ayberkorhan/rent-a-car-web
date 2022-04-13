package com.duzce.vtys.rentacar.dto;

import com.duzce.vtys.rentacar.model.DriverLicence;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;


public class DriverLicenceDto implements Serializable{

    public DriverLicenceDto(){}
    private Long driverLicenceId;
    private String licenceType;
    private Date date;

    public DriverLicenceDto(Long driverLicenceId, String licenceType, Date date) {
        this.driverLicenceId = driverLicenceId;
        this.licenceType = licenceType;
        this.date = date;
    }

    public Long getDriverLicenceId() {
        return driverLicenceId;
    }

    public void setDriverLicenceId(Long driverLicenceId) {
        this.driverLicenceId = driverLicenceId;
    }

    public String getLicenceType() {
        return licenceType;
    }

    public void setLicenceType(String licenceType) {
        this.licenceType = licenceType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
