package com.duzce.vtys.rentacar.dto;

import com.duzce.vtys.rentacar.model.OrderStatus;
import org.springframework.stereotype.Component;

@Component
public class OrderStatusConverter {

    public static OrderStatusDto Convert(OrderStatus orderStatus){

        return new OrderStatusDto(
            orderStatus.getStatusId(),
                orderStatus.getStatus()

        );
    }


}
