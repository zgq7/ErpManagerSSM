package com.erp.serviceImpl;

import com.erp.dao.CustomerDao;
import com.erp.pojo.Customer;
import com.erp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerDao customerDao;

    @Override
    public String Login(Customer customer) {
        return customerDao.Login(customer);
    }

    @Override
    public List<Customer> CatchAllCustomer() {
        System.out.println("dao....");
        return customerDao.CatchAllCustomer();
    }
}
