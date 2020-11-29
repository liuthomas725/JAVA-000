package org.cc.service;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrderService1 {

    public Connection getConn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC","root","14/2");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insert(){
        Connection con  = getConn();
        PreparedStatement preparedStatement;
        try {
            con.setAutoCommit(false);
            for(int i = 0 ;i < 10000;i++){
                preparedStatement = con.prepareStatement("INSERT INTO t_store_order(store_order_id,user_id,store_name,store_id,order_num,address_id,status,freight_id,create_time,update_time) VALUES(?,?,?,?,?,?,?,?,?,?)");
                preparedStatement.setLong(1,i);
                preparedStatement.setLong(2,1);
                preparedStatement.setString(3,"红色");
                preparedStatement.setLong(4,1);
                preparedStatement.setInt(5,1);
                preparedStatement.setLong(6,1);
                preparedStatement.setInt(7,1);
                preparedStatement.setLong(8,1);
                preparedStatement.setDate(9,Date.valueOf(LocalDate.now()));
                preparedStatement.setDate(10,Date.valueOf(LocalDate.now()));
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {
                con.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());
        OrderService1 orderService1 = new OrderService1();
        orderService1.insert();
        System.out.println(LocalDateTime.now());
    }
}
