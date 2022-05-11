package com.duzce.vtys.rentacar.controller;

import com.duzce.vtys.rentacar.dto.car.CarDto;
import com.duzce.vtys.rentacar.dto.car.CarWithInfoAndLocation;
import com.duzce.vtys.rentacar.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
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
    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getCarByID(@PathVariable("id") Long id){
        return ResponseEntity.ok(carService.getCarById(id));
    }
    @GetMapping()
    public ResponseEntity<List<CarDto>> getAllCarsWithDetail(){
        return ResponseEntity.ok(carService.getAllCarsWithDetail());
    }


}
