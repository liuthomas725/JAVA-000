package org.cc.service;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;

public class OrderService1 {

    public Connection getConn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&rewriteBatchedStatements=true&useServerPrepStmts=true","root","14/2");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 耗时
     * 2020-12-02T23:36:04.132
     * 2020-12-02T23:36:58.946
     */
    public void insert1(){
        Connection con  = getConn();
        PreparedStatement preparedStatement;
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement("INSERT INTO t_store_order(store_order_id,user_id,store_name,store_id,order_num,address_id,status,freight_id,create_time,update_time) VALUES(?,?,?,?,?,?,?,?,?,?)");
            for(int i = 1 ;i <= 1000000;i++){
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
                preparedStatement.addBatch();
                if(i % 100000 == 0){
                    preparedStatement.executeBatch();
                }
            }
            preparedStatement.executeBatch();
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

    /**
     * 耗时
     * 2020-12-02T23:06:16.576
     * 2020-12-02T23:07:22.733
     */
    public void insert2(){
        Connection con  = getConn();
        try {
            con.setAutoCommit(false);
            StringBuilder sql = new StringBuilder("INSERT INTO t_store_order(store_order_id,user_id,store_name,store_id,order_num,address_id,`status`,freight_id,create_time,update_time) VALUES");
            String one = String.valueOf(1);
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String date = dateFormat.format(LocalDate.now());
            Statement statement = con.createStatement();
            StringJoiner allValues = new StringJoiner(",");
            for(int i = 0 ;i < 1000000;i++){
                StringJoiner str = new StringJoiner(",","(",")");
                str.add(String.valueOf(i));
                str.add(one);
                str.add("'红色'");
                str.add(one);
                str.add(one);
                str.add(one);
                str.add(one);
                str.add(one);
                str.add("'"+date + "'");
                str.add("'"+date + "'");
                allValues.add(str.toString());
            }
            sql.append(allValues);
            statement.execute(sql.toString());
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
        orderService1.insert1();
        System.out.println(LocalDateTime.now());
    }
}
