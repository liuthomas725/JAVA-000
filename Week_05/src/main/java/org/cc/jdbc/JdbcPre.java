package org.cc.jdbc;

import java.sql.*;

public class JdbcPre {
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
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("SELECT * FROM fruit WHERE fruitid = ?");
            preparedStatement.setLong(1,1);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(){
        Connection con  = getConn();
        PreparedStatement preparedStatement ;
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement("UPDATE fruit SET fruitname = ? WHERE fruitid = ?");
            preparedStatement.setString(1,"香蕉");
            preparedStatement.setLong(2,1);
            preparedStatement.execute();
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

    public void delete(){
        Connection con  = getConn();
        PreparedStatement preparedStatement ;
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement("DELETE FROM fruit  WHERE fruitid = ?");
            preparedStatement.setLong(1,1);
            preparedStatement.execute();
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

    public void insert(){
        Connection con  = getConn();
        PreparedStatement preparedStatement;
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement("INSERT INTO fruit(fruitid,fruitname,fruitcolor,fruitindex) VALUES(?,?,?,?)");
            preparedStatement.setLong(1,1);
            preparedStatement.setString(2,"苹果");
            preparedStatement.setString(3,"红色");
            preparedStatement.setLong(4,1);
            preparedStatement.execute();
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
        JdbcPre jdbcTest = new JdbcPre();
        jdbcTest.query();
        jdbcTest.update();
        jdbcTest.delete();
        jdbcTest.insert();
    }
}
