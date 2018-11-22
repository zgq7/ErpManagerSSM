package com.erp;

import com.erp.controller.TestController;
import com.erp.dao.CustomerDao;
import com.erp.pojo.Customer;
import com.erp.service.CustomerService;
import com.erp.serviceImpl.CustomerServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration("classpath:spring-mybatis.xml")
public class test {
    @Test
    public void testJdbc(){
        Connection connection;
        String Drivermanager = "com.mysql.jdbc.Driver";
        String driverType = "jdbc:mysql://";
        String ip = "localhost";
        String port = "3306";
        String DatabaseName = "ErpManagerSSM";
        String username = "root";
        String password = "root";
        try {
            String basicUrl = driverType+ip+":"+port+";DatabaseName="+DatabaseName;
            Class.forName(Drivermanager);
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/ErpManagerSSM?useUnicode=true&characterEncoding=utf8", username, password);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("jdbc connect fail");
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("the sql have errors");
        }
        System.out.println("jdbc connect success");
    }

    private CustomerService customerService;
    @Test
    public void mybatisTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        CustomerService customerService = applicationContext.getBean(CustomerService.class);
        System.out.println(1);
        CustomerServiceImpl customerServiceimpl = applicationContext.getBean(CustomerServiceImpl.class);
        System.out.println(2);
        CustomerDao customerDao = applicationContext.getBean(CustomerDao.class);
        System.out.println(3);
        Customer customer = applicationContext.getBean(Customer.class);
        System.out.println(4);
    }
}
