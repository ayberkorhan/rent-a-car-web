package com.duzce.vtys.rentacar.service;


import com.duzce.vtys.rentacar.dto.CustomerDto;
import com.duzce.vtys.rentacar.exception.CustomerNotFoundException;
import com.duzce.vtys.rentacar.model.Car;
import com.duzce.vtys.rentacar.model.Customer;
import com.duzce.vtys.rentacar.model.Order;
import com.duzce.vtys.rentacar.model.OrderStatus;
import com.duzce.vtys.rentacar.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {


    private final CustomerService customerService;
    private final CarService carService;
    private final OrderRepository orderRepository;



    public OrderService(OrderRepository orderRepository, CustomerService customerService, CarService carService, OrderRepository orderRepository1) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        this.carService = carService;
    }




    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    public List<Order> getCustomerOrder(Optional<Customer> a) {
        return orderRepository.findByCustomer(a);
    }

    public List<Order> getCarOrder(Optional<Car> a) {return orderRepository.findByCar(a);
    }

    public Order save(Order order) {
        Customer customer = customerService.
                findCustomerById(order.getCustomer().getCustomerId());

        order.setCustomer(customer);

        Car car = carService.findCarById(order.getCar().getCarId());

        order.setCustomer(customer);
        order.setCar(car);
        orderRepository.save(order);
        return order;
    }

    public Order saveall(Order order) {
        Customer customer = customerService.saveAll(order.getCustomer());

        order.setCustomer(customer);

        Car car = carService.saveAll(order.getCar());

        order.setCustomer(customer);
        order.setCar(car);
        orderRepository.save(order);
        return order;
    }





    public Boolean deleteOrderById(Long id) throws CustomerNotFoundException {
        Order order =orderRepository.getById(id); //getCustomerById(id);
        orderRepository.deleteById(id);
        return Boolean.TRUE;
    }



    public Order findOrderById(Long id) throws CustomerNotFoundException {
        return orderRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException("Customer could not find by id: " + id.toString())
        );
    }




}
