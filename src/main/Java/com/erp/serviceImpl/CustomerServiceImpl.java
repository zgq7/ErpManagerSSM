package com.erp.serviceImpl;

import com.erp.dao.CustomerDao;
import com.erp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2018/11/22.
 */
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerDao customerDao;
    @Override
    public boolean Login(String cardNo, String password) {
        return customerDao.Login(cardNo, password);
    }
}
