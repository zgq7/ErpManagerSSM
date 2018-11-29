package com.erp.dao;


import com.erp.pojo.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RegLogCustomerDao {
    String Login(Customer customer);
    Integer checkRegInfo(@Param("cardNo") String cardNo);
    String Register(Customer customer);
    List<Customer> CatchAllCustomer();
}
