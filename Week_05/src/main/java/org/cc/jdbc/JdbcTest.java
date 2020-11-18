package org.cc.jdbc;

import java.sql.*;

public class JdbcTest {

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

    public void query(){
        Connection con  = getConn();
        Statement statement = null;
        try {
            statement = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.executeQuery("SELECT * FROM fruit");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(){
        Connection con  = getConn();
        Statement statement = null;
        try {
            statement = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.executeUpdate("UPDATE fruit SET fruitname = '香蕉' WHERE fruitid = 1 ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(){
        Connection con  = getConn();
        Statement statement = null;
        try {
            statement = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.executeUpdate("DELETE FROM fruit  WHERE fruitid = 1 ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(){
        Connection con  = getConn();
        Statement statement = null;
        try {
            statement = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.executeUpdate("INSERT INTO fruit(fruitid,fruitname,fruitcolor,fruitindex) VALUES(1,'苹果','红色',1)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        JdbcTest jdbcTest = new JdbcTest();
        jdbcTest.query();
        jdbcTest.update();
        jdbcTest.delete();
        jdbcTest.insert();
    }
}
