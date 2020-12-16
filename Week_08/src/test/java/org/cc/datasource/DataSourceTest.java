package org.cc.datasource;

import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DataSourceApplication.class)
public class DataSourceTest {
    @Resource
    private DataSource dataSource;
    @Resource
    private XAService xaService;

    @Test
    public void query() {
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM t_store_order WHERE store_order_id = ?");
            preparedStatement.setLong(1, 1);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void update() {
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement("UPDATE t_store_order SET order_num = ? WHERE store_order_id = ?");
            preparedStatement.setInt(1, 3);
            preparedStatement.setLong(2, 1);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delete() {
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM t_store_order  WHERE store_order_id = ?");
            preparedStatement.setLong(1, 1);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insert() {
        TransactionTypeHolder.set(TransactionType.XA);
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO t_store_order(store_order_id) VALUES(?)");
            preparedStatement.setLong(1, 2);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertAnddelete() throws Exception {
        xaService.insertAnddelete();
    }
}
