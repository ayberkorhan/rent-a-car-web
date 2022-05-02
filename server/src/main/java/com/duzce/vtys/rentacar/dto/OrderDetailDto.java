package com.duzce.vtys.rentacar.dto;

public class OrderDetailDto {

    private Long OrderDetailId;

    private String CreatedDate;

    private  String ExamineDate;

    private  Integer Price;

    private  Integer OrderDay;

    private Long Id;

    private Long OrderStatusId;

    private String pickUpDate;

    private String returnDate;

    private  String carClass;

    private String fuelType;

    private  String firstName;

   private String lastName;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public OrderDetailDto(Long OrderDetailId, String CreatedDate, String ExamineDate, Integer Price, Long Id,
                          String pickUpDate, String returnDate, Long statusId, String carClass, String fuelType,
                          String plate, Long customerId, String firstName, String lastName, Long id, Integer price, Integer OrderDay) {
        this.OrderDetailId = OrderDetailId;
        this.CreatedDate = CreatedDate;
        this.ExamineDate = ExamineDate;
        this.Price = Price;
        this.OrderDay = OrderDay;
        this.Id = Id;
        this.OrderStatusId = statusId;
        this.pickUpDate= pickUpDate;
        this.returnDate= returnDate;
        this.fuelType = fuelType;
        this.firstName = firstName;
        this.lastName = lastName;
    }






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

    public Long getOrderId() {
        return Id;
    }

    public void setOrderId(Long orderId) {
        Id = orderId;
    }

    public Long getOrderStatusId() {
        return OrderStatusId;
    }

    public void setOrderStatusId(Long orderStatusId) {
        OrderStatusId = orderStatusId;
    }



}


  /*

    private String CreatedDate;

    private  String ExamineDate;

   private  Integer Price;

    private  Integer OrderDay;


    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @JsonIgnore
    private Order order;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "order_status_id", referencedColumnName = "statusid")
    @JsonIgnore
    private OrderStatus orderStatus;

    */