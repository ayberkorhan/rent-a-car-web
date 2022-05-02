package com.duzce.vtys.rentacar.controller;

import com.duzce.vtys.rentacar.dto.CustomerDto;
import com.duzce.vtys.rentacar.model.Car;
import com.duzce.vtys.rentacar.model.Customer;
import com.duzce.vtys.rentacar.model.Order;
import com.duzce.vtys.rentacar.repository.CarRepository;
import com.duzce.vtys.rentacar.repository.CustomerRepository;
import com.duzce.vtys.rentacar.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {


    private final OrderService orderService;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    public OrderController(OrderService orderService, CarRepository carRepository, CustomerRepository customerRepository) {
        this.orderService = orderService;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Order> getByidOrder(@PathVariable Long id){ return ResponseEntity.ok(orderService.findOrderById(id));
    }
    @GetMapping()
    public ResponseEntity<List<Order>> getAllOrder(){ return ResponseEntity.ok(orderService.getAllOrder());
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<List<Order>> getAllCustomer(@PathVariable Long id){

        Optional<Customer> customer = customerRepository.findById(id);

        return ResponseEntity.ok(orderService.getCustomerOrder(customer));
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<List<Order>> getAllCar(@PathVariable Long id){

        Optional<Car> car = carRepository.findById(id);

        return ResponseEntity.ok(orderService.getCarOrder(car));
    }

    @PostMapping()
    public ResponseEntity<Order> createNewCustomer(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.save(order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCustomerById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(orderService.deleteOrderById(id));
    }


}
