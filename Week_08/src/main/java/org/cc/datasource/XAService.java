package org.cc.datasource;

import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class XAService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @ShardingTransactionType(TransactionType.XA)
    @Transactional(rollbackFor = Exception.class)
    public void insertAnddelete() throws Exception {
        jdbcTemplate.execute("INSERT INTO t_store_order (store_order_id) VALUES (?)", (PreparedStatementCallback<Object>) preparedStatement -> {
            preparedStatement.setObject(1, 2);
            return preparedStatement.execute();
        });
        jdbcTemplate.execute("UPDATE t_store_order SET order_num = ? WHERE store_order_id = ?", (PreparedStatementCallback<Object>) preparedStatement -> {
            preparedStatement.setObject(1, 3);
            preparedStatement.setObject(2, 2);
            preparedStatement.executeUpdate();
            return 1;
        });
        throw  new Exception("出错了");
    }
}
