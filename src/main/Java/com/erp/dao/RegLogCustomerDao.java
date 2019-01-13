package com.erp.dao;


import com.erp.pojo.Customer;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RegLogCustomerDao {
    @Select("CALL customer_login(#{cardNo}, #{password});")
    String Login(@Param("cardNo") String cardNo, @Param("password") String password);

    Integer checkRegInfo(@Param("cardNo") String cardNo);

    String Register(Customer customer);

    List<Customer> CatchAllCustomer();
}
