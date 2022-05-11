package com.duzce.vtys.rentacar.repository;

import com.duzce.vtys.rentacar.model.CustomerAdress;
import com.duzce.vtys.rentacar.model.CustomerLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerLoginRepository extends JpaRepository<CustomerLogin,Long> {
    @Query(value = "select * from customer_login where email=:email and login_password=:password",
            nativeQuery = true)
    public CustomerLogin getCustomerLoginByCustomerEqualsAndEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
