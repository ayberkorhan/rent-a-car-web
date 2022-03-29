package com.duzce.vtys.rentacar.controller;

import com.duzce.vtys.rentacar.model.Car;
import com.duzce.vtys.rentacar.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {

    private final CarService carService;

    public CarController (CarService carService){
        this.carService = carService;
    }


    @GetMapping
    public List<Car> getCar(){
            return carService.getAllCar();
    }
}
