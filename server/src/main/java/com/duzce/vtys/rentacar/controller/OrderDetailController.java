package com.duzce.vtys.rentacar.controller;

import com.duzce.vtys.rentacar.dto.OrderDetailDto;
import com.duzce.vtys.rentacar.dto.OrderStatusDto;
import com.duzce.vtys.rentacar.model.Order;
import com.duzce.vtys.rentacar.model.OrderDetail;
import com.duzce.vtys.rentacar.service.OrderDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orderdetail")
public class OrderDetailController {

    private  final OrderDetailService orderDetailService;


    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @PostMapping()
    public ResponseEntity<OrderDetailDto> createNewCustomer(@RequestBody OrderDetail orderDetail) {
        return ResponseEntity.ok(orderDetailService.save(orderDetail));
    }

    @PostMapping("/all")
    public ResponseEntity<OrderDetailDto> createAllCustomer(@RequestBody OrderDetail orderDetail) {
        return ResponseEntity.ok(orderDetailService.saveAll(orderDetail));
    }



    @GetMapping("/{id}")
    public ResponseEntity<OrderDetail> getByidOrderDetail(@PathVariable Long id){ return ResponseEntity.ok(orderDetailService.findOrderDetailById(id));
    }
    @GetMapping()
    public ResponseEntity<List<OrderDetail>> getAllOrderDetail(){ return ResponseEntity.ok(orderDetailService.getAllOrderDetail());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderDetailDto> deleteCustomerById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(orderDetailService.deleteCustomerById(id));
    }
}
