package com.erp.service;

import com.erp.pojo.Customer;

import java.util.List;

public interface CustomerService {
    String Login(Customer customer);
    List<Customer> CatchAllCustomer();
}
