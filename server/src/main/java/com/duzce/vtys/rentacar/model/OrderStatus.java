package com.duzce.vtys.rentacar.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ORDER_STATUS")
public class OrderStatus {

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long statusId;



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "Status")
    private String status;


    /*public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }*/

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @OneToMany(mappedBy = "orderStatus", cascade = CascadeType.ALL)
    Set<OrderDetail> orderDetails;


}
