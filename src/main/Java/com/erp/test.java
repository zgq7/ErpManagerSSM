package com.erp;

import com.erp.dao.RegLogCustomerDao;
import com.erp.pojo.Customer;
import com.erp.service.CustomerService;
import com.erp.service.serviceImpl.CustomerServiceImpl;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
            connection.close();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("jdbc connect fail");
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("the sql have errors");
        }
        System.out.println("jdbc connect success");
    }

    @Test
    public void mybatisTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-shiro.xml");
        ShiroFilter shiroFilter = (ShiroFilter) applicationContext.getBean("shiroFilter");
        System.out.println(shiroFilter.toString());
    }
}