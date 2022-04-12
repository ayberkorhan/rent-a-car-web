package com.duzce.vtys.rentacar.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "car_info")
public class CarInfo implements Serializable {

    public CarInfo() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long carInfoId;

    private String brand;

    private String model;

    private String year;

    private String kilometer;

    @OneToOne(mappedBy = "carInfo")
    private Car car;


    public Long getCarInfoId() {
        return carInfoId;
    }

    public void setCarInfoId(Long carInfoId) {
        this.carInfoId = carInfoId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getKilometer() {
        return kilometer;
    }

    public void setKilometer(String kilometer) {
        this.kilometer = kilometer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
