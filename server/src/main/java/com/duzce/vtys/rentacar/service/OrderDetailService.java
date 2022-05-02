package com.duzce.vtys.rentacar.service;

import com.duzce.vtys.rentacar.dto.OrderDetailConverter;
import com.duzce.vtys.rentacar.dto.OrderDetailDto;
import com.duzce.vtys.rentacar.dto.OrderStatusDto;
import com.duzce.vtys.rentacar.exception.CustomerNotFoundException;
import com.duzce.vtys.rentacar.model.*;
import com.duzce.vtys.rentacar.repository.OrderDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {

    private final OrderService orderService;
    private final OrderStatusService orderStatusService;
    private  final OrderDetailRepository orderDetailRepository;
    private final  OrderDetailConverter orderDetailConverter;

    public OrderDetailService(OrderService orderService, OrderStatusService orderStatusService, OrderDetailRepository orderDetailRepository, OrderDetailConverter orderDetailConverter) {
        this.orderService = orderService;
        this.orderStatusService = orderStatusService;
        this.orderDetailRepository = orderDetailRepository;

        this.orderDetailConverter = orderDetailConverter;
    }

    public OrderDetailDto save( OrderDetail orderDetail){
        Order order = orderService.findOrderById(orderDetail.getOrder().getId());
       OrderStatus orderStatus = orderStatusService.findOrderStatusById(orderDetail.getOrderStatus().getStatusId());

        orderDetail.setOrder(order);
       orderDetail.setOrderStatus(orderStatus);
        orderDetailRepository.save(orderDetail);

        return OrderDetailConverter.Convert(orderDetail);
    }
    public OrderDetail findOrderDetailById(Long id) throws CustomerNotFoundException {
        return orderDetailRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException("Customer could not find by id: " + id.toString())
        );
    }

    public List<OrderDetail> getAllOrderDetail() {
        return orderDetailRepository.findAll();
    }

    public OrderDetailDto getOrderStatusById(Long id) throws CustomerNotFoundException {
        return orderDetailConverter
                .Convert(orderDetailRepository.findById(id)
                        .orElseThrow(() -> new CustomerNotFoundException(id.toString() + "Numaralı Kullanıcı Bulunamadı")));
    }

    public OrderDetailDto deleteCustomerById(Long id) throws CustomerNotFoundException {
        OrderDetailDto orderStatus = getOrderStatusById(id);
        orderDetailRepository.deleteById(id);
        return orderStatus;
    }


    public OrderDetailDto saveAll( OrderDetail orderDetail){
        Order order = orderService.saveall(orderDetail.getOrder());
        OrderStatus orderStatus = orderStatusService.save(orderDetail.getOrderStatus());

        orderDetail.setOrder(order);
        orderDetail.setOrderStatus(orderStatus);
        orderDetailRepository.save(orderDetail);

        return OrderDetailConverter.Convert(orderDetail);
    }





}




/*

    Customer customer = customerService.
            findCustomerById(order.getCustomer().getCustomerId());

        order.setCustomer(customer);

                Car car = carService.findCarById(order.getCar().getCarId());

                order.setCustomer(customer);
                order.setCar(car);
                orderRepository.save(order);

    public CarDto saveCar(Car car, CarInfo carInfo, CarLocation carLocation) {
        carInfo=carInfoService.saveCarInfo(carInfo);
        carLocation=carLocationService.saveCarLocation(carLocation);
        car.setCarInfo(carInfo);
        car.setCarLocation(carLocation);
        carRepository.save(car);
        return carDtoConverter.convert(car,carInfo,carLocation);
    }*/
