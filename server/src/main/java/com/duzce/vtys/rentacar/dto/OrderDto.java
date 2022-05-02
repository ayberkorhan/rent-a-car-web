package com.duzce.vtys.rentacar.dto;

import com.duzce.vtys.rentacar.model.Car;
import com.duzce.vtys.rentacar.model.Customer;
import com.duzce.vtys.rentacar.model.OrderDetail;

import javax.persistence.*;

public class OrderDto {

    private  Long id;

    private String pickUpDate;

    private String returnDate;





}

/*

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "pick_up_date")
    private String pickUpDate;

    @Column(name = "return_date")
    private String returnDate;

    @ManyToOne
    @JoinColumn(name = "car_id")
    Car car;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    @OneToOne(mappedBy = "order")
    private OrderDetail orderDetail;
*/
