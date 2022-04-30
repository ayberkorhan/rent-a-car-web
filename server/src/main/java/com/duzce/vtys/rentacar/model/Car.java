package com.duzce.vtys.rentacar.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Car implements Serializable {

    public Car() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long carId;

    @Column(unique = true)
    private String plate;

    private String carClass;

    private String fuelType;

    private String gearType;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "car_info_id",unique = true)
    @JsonIgnore
    private CarInfo carInfo;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "car_location_id",unique = true)
    @JsonIgnore
    private CarLocation carLocation;


   @OneToMany(mappedBy = "car")
    Set<Order> order;

    //Getter and Setter Methods


    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType;
    }

    public CarInfo getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(CarInfo carInfo) {
        this.carInfo = carInfo;
    }

    public CarLocation getCarLocation() {
        return carLocation;
    }

    public void setCarLocation(CarLocation carLocation) {
        this.carLocation = carLocation;
    }
}
