package org.cc.jdbc;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HikariTest {
    public Connection getConn(){
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");
        hikariDataSource.setUsername("root");
        hikariDataSource.setPassword("14/2");
        hikariDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        try {
            return hikariDataSource.getConnection();
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
        HikariTest jdbcTest = new HikariTest();
        jdbcTest.query();
        jdbcTest.update();
        jdbcTest.delete();
        jdbcTest.insert();
    }
}
