package com.duzce.vtys.rentacar.repository;

import com.duzce.vtys.rentacar.model.CarInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarInfoRepository extends JpaRepository<CarInfo,Long> {
}
