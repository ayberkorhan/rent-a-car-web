package com.duzce.vtys.rentacar.service;


import com.duzce.vtys.rentacar.model.Car;
import com.duzce.vtys.rentacar.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService (CarRepository carRepository){
        this.carRepository=carRepository;
    }

    public List<Car> getAllCar(){
        return carRepository.findAll();
    }



}
