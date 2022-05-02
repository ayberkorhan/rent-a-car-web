package com.duzce.vtys.rentacar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_DETAIl")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long OrderDetailId;

    private String CreatedDate;

    private  String ExamineDate;

    private  Integer Price;

    private  Integer OrderDay;


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @ManyToOne
    @JoinColumn(name = "order_id")
    Order order;

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @ManyToOne
    @JoinColumn(name = "status_id")
    OrderStatus orderStatus;


    public Long getOrderDetailId() {
        return OrderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        OrderDetailId = orderDetailId;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        CreatedDate = createdDate;
    }

    public String getExamineDate() {
        return ExamineDate;
    }

    public void setExamineDate(String examineDate) {
        ExamineDate = examineDate;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public Integer getOrderDay() {
        return OrderDay;
    }

    public void setOrderDay(Integer orderDay) {
        OrderDay = orderDay;
    }








}

  /*  ORDER_DETAIL_ID NUMBER(10),
    ORDER_ID NUMBER(10) UNIQUE NOT NULL,
    CREATED_DATE DATE NOT NULL,
    EXAMINE_DATE DATE NOT NULL,
    PRICE NUMBER(10,2) NOT NULL,
    ORDER_DAY NUMBER (3) NOT NULL,
    STATUS_ID NUMBER(10) NOT NULL,*/