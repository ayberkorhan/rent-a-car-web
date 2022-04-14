package com.duzce.vtys.rentacar.repository;

import com.duzce.vtys.rentacar.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CarRepository extends JpaRepository<Car,Long> {


}
