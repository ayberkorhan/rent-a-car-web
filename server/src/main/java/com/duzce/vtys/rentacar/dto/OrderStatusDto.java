package com.duzce.vtys.rentacar.dto;

import java.io.Serializable;

public class OrderStatusDto  implements Serializable{

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    private Long statusId;



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;

    public OrderStatusDto(Long statusId, String status){
        this.statusId= statusId;
        this.status=  status;
    }
}
