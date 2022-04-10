package com.duzce.vtys.rentacar.repository;


import com.duzce.vtys.rentacar.model.CustomerAdress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CustomerAdressRepository extends  JpaRepository<CustomerAdress, Long> {

    @Query(value = "select * from customer_adress where customer_id=:id",
            nativeQuery = true)
    public List<CustomerAdress> getCustomerAdressByCustomerId(@Param("id") Long id);

}
