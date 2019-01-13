package com.erp.service.serviceImpl;

import com.erp.dao.RegLogCustomerDao;
import com.erp.pojo.Customer;
import com.erp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("CustomerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private RegLogCustomerDao regLogCustomerDao;

    @Override
    public String Login(Customer customer) {
        return regLogCustomerDao.Login(customer.getCardNo(),customer.getPassword());
    }

    @Override
    public Integer checkRegInfo(String cardNo) {
        return regLogCustomerDao.checkRegInfo(cardNo);
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
