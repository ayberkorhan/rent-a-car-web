package com.duzce.vtys.rentacar.repository;

import com.duzce.vtys.rentacar.model.Order;
import com.duzce.vtys.rentacar.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
}
