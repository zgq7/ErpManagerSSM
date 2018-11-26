package com.erp.dao;


import com.erp.pojo.Customer;

import java.util.List;

public interface RegLogCustomerDao {
    String Login(Customer customer);
    String Register(Customer customer);
    List<Customer> CatchAllCustomer();
}
