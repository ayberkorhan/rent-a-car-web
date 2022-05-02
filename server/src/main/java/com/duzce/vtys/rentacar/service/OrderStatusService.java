package com.duzce.vtys.rentacar.service;

import com.duzce.vtys.rentacar.dto.OrderStatusConverter;
import com.duzce.vtys.rentacar.dto.OrderStatusDto;
import com.duzce.vtys.rentacar.exception.CustomerNotFoundException;
import com.duzce.vtys.rentacar.model.OrderStatus;
import com.duzce.vtys.rentacar.repository.OrderRepository;
import com.duzce.vtys.rentacar.repository.OrderStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderStatusService {

    private  final OrderStatusRepository orderStatusRepository;
    private final OrderStatusConverter orderStatusConverter;

    public OrderStatusService(OrderRepository orderRepository, OrderStatusRepository orderStatusRepository, OrderStatusConverter orderStatusConverter) {
        this.orderStatusRepository = orderStatusRepository;
        this.orderStatusConverter = orderStatusConverter;
    }

    public OrderStatus findOrderStatusById(Long id) throws CustomerNotFoundException {
        return orderStatusRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException("Customer could not find by id: " + id.toString())
        );
    }

    public OrderStatus save(OrderStatus orderStatus){

        orderStatusRepository.save(orderStatus);

        return orderStatus;
    }

    public List<OrderStatus> getAllOrderStatus() {
        return orderStatusRepository.findAll();
    }

    public OrderStatusDto getOrderStatusById(Long id) throws CustomerNotFoundException {
        return orderStatusConverter
                .Convert(orderStatusRepository.findById(id)
                        .orElseThrow(() -> new CustomerNotFoundException(id.toString() + "Numaralı Kullanıcı Bulunamadı")));
    }


    public OrderStatusDto deleteCustomerById(Long id) throws CustomerNotFoundException {
        OrderStatusDto orderStatus = getOrderStatusById(id);
        orderStatusRepository.deleteById(id);
        return orderStatus;
    }
}

