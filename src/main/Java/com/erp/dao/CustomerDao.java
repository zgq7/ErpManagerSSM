package com.erp.dao;


import com.erp.pojo.Customer;

import java.util.List;

public interface CustomerDao {
    String Login(Customer customer);
    List<Customer> CatchAllCustomer();
}
