package com.duzce.vtys.rentacar.controller;

import com.duzce.vtys.rentacar.dto.CustomerDto;
import com.duzce.vtys.rentacar.dto.OrderStatusDto;
import com.duzce.vtys.rentacar.model.Customer;
import com.duzce.vtys.rentacar.model.Order;
import com.duzce.vtys.rentacar.model.OrderStatus;
import com.duzce.vtys.rentacar.service.CustomerService;
import com.duzce.vtys.rentacar.service.OrderStatusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orderstatus")
public class OrderStatusController {


    private  final OrderStatusService orderStatusService;

    public OrderStatusController( OrderStatusService orderStatusService) {

        this.orderStatusService = orderStatusService;
    }

    @PostMapping()
    public ResponseEntity<OrderStatus> AddStatus(@RequestBody OrderStatus orderStatus) {
        return ResponseEntity.ok(orderStatusService.save(orderStatus));
    }

    @GetMapping()
    public ResponseEntity<List<OrderStatus>> getAllOrderStatus(){ return ResponseEntity.ok(orderStatusService.getAllOrderStatus());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderStatus> getByidOrder(@PathVariable Long id){ return ResponseEntity.ok(orderStatusService.findOrderStatusById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderStatusDto> deleteCustomerById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(orderStatusService.deleteCustomerById(id));
    }

}
