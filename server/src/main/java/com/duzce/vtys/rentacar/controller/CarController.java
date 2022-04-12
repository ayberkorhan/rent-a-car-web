package com.duzce.vtys.rentacar.controller;

import com.duzce.vtys.rentacar.dto.CarDto;
import com.duzce.vtys.rentacar.dto.CarWithInfoAndLocation;
import com.duzce.vtys.rentacar.model.Car;
import com.duzce.vtys.rentacar.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }


    @PostMapping("")
    public ResponseEntity<CarDto> postCarWithInfoAndLocation(@RequestBody CarWithInfoAndLocation carDetail) {
        return ResponseEntity.ok(carService.saveCar(carDetail.getCar(), carDetail.getCarInfo(), carDetail.getCarLocation()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCar(@PathVariable("id") Long id) {
        return ResponseEntity.ok(carService.deleteCarById(id));
    }
    @GetMapping()
    public ResponseEntity<List<Car>> getAllCar(){
        return ResponseEntity.ok(carService.getAll());
    }


}
