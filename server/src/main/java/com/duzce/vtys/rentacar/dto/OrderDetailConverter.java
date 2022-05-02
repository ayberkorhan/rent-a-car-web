package com.duzce.vtys.rentacar.dto;

import com.duzce.vtys.rentacar.model.Customer;
import com.duzce.vtys.rentacar.model.OrderDetail;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailConverter {


    public static OrderDetailDto Convert(OrderDetail orderDetail) {
        return new OrderDetailDto(
                orderDetail.getOrderDetailId(),
                orderDetail.getCreatedDate(),
                orderDetail.getExamineDate(),
                orderDetail.getOrderDay(),
                orderDetail.getOrder().getId(),
                orderDetail.getOrder().getPickUpDate(),
                orderDetail.getOrder().getReturnDate(),
                orderDetail.getOrder().getCar().getCarId(),
                orderDetail.getOrder().getCar().getCarClass(),
                orderDetail.getOrder().getCar().getFuelType(),
                orderDetail.getOrder().getCar().getPlate(),
                orderDetail.getOrder().getCustomer().getCustomerId(),
                orderDetail.getOrder().getCustomer().getFirstName(),
                orderDetail.getOrder().getCustomer().getLastName(),
                orderDetail.getOrderStatus().getStatusId(),
                orderDetail.getPrice(),
                orderDetail.getOrderDay());
    }

}
