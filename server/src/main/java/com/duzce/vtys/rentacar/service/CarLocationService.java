package com.duzce.vtys.rentacar.service;

import com.duzce.vtys.rentacar.model.CarLocation;
import com.duzce.vtys.rentacar.repository.CarLocationRepository;
import org.springframework.stereotype.Service;

@Service
public class CarLocationService {

    private final CarLocationRepository carLocationRepository;

    public CarLocationService(CarLocationRepository carLocationRepository) {
        this.carLocationRepository = carLocationRepository;
    }

    public CarLocation saveCarLocation(CarLocation carLocation) {
        return carLocationRepository.save(carLocation);
    }
}
