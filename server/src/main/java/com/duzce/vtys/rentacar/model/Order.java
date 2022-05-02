package com.duzce.vtys.rentacar.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "customer_order")
public class Order implements Serializable {

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

    /*public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }*/

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @OneToMany(mappedBy = "order")
    Set<OrderDetail> orderDetails;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


}
