package com.duzce.vtys.rentacar.repository;

import com.duzce.vtys.rentacar.model.CustomerLogin;
import com.duzce.vtys.rentacar.model.EmployeeLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeLoginRepository extends JpaRepository<EmployeeLogin,Long> {
    @Query(value = "select * from employee_login where email=:email and login_password=:password",
            nativeQuery = true)
    public EmployeeLogin getEmployeeLoginByEmailAndPassword(@Param("email") String email, @Param("password") String password);


}
