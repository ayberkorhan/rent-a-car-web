package com.duzce.vtys.rentacar.repository;

import com.duzce.vtys.rentacar.model.Car;
import com.duzce.vtys.rentacar.model.Customer;
import com.duzce.vtys.rentacar.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Long> {

       // List<Order> findByReturnDate(Long returnDate);

        List<Order> findByCar(Optional<Car> car);

    List<Order> findByCustomer(Optional<Customer> a);
}

