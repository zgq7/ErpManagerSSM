package com.erp;

import org.junit.Test;
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
            System.out.println(basicUrl);
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
}
