package com.duzce.vtys.rentacar.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CarLocation implements Serializable {

    public CarLocation() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long carLocationId;

    private String latitude;

    private String longitude;

    @OneToOne(mappedBy = "carLocation")
    private Car car;

    public Long getCarLocationId() {
        return carLocationId;
    }

    public void setCarLocationId(Long carLocationId) {
        this.carLocationId = carLocationId;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
