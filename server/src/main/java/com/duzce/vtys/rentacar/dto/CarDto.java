package com.duzce.vtys.rentacar.dto;

import java.io.Serializable;

public class CarDto implements Serializable {
    private Long carId;
    private Long carInfoId;
    private Long carLocationId;
    private String plate;
    private String carClass;
    private String fuelType;
    private String gearType;
    private String brand;
    private String model;
    private String year;
    private String kilometer;
    private String latitude;
    private String longitude;

    public CarDto(){}


    public CarDto(Long carId, Long carInfoId, Long carLocationId, String plate, String carClass, String fuelType, String gearType, String brand, String model, String year, String kilometer, String latitude, String longitude) {
        this.carId = carId;
        this.carInfoId = carInfoId;
        this.carLocationId = carLocationId;
        this.plate = plate;
        this.carClass = carClass;
        this.fuelType = fuelType;
        this.gearType = gearType;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.kilometer = kilometer;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public CarDto(Long carId, String plate, String carClass, String fuelType) {
    }


    public Long getCarInfoId() {
        return carInfoId;
    }

    public void setCarInfoId(Long carInfoId) {
        this.carInfoId = carInfoId;
    }

    public Long getCarLocationId() {
        return carLocationId;
    }

    public void setCarLocationId(Long carLocationId) {
        this.carLocationId = carLocationId;
    }

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

    @Override
    public String toString() {
        return "CarDto{" +
                "carId=" + carId +
                ", carInfoId=" + carInfoId +
                ", carLocationId=" + carLocationId +
                ", plate='" + plate + '\'' +
                ", carClass='" + carClass + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", gearType='" + gearType + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", kilometer='" + kilometer + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
