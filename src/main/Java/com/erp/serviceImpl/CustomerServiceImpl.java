package com.erp.serviceImpl;

import com.erp.dao.RegLogCustomerDao;
import com.erp.pojo.Customer;
import com.erp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private RegLogCustomerDao regLogCustomerDao;

    @Override
    public String Login(Customer customer) {
        return regLogCustomerDao.Login(customer);
    }

    @Override
    public String Register(Customer customer) {
        return regLogCustomerDao.Register(customer);
    }

    @Override
    public List<Customer> CatchAllCustomer() {
        return regLogCustomerDao.CatchAllCustomer();
    }
}
