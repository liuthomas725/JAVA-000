package org.cc.service;

import lombok.SneakyThrows;
import org.apache.dubbo.config.annotation.DubboService;
import org.cc.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;

@DubboService(interfaceName="bTransferService")
public class BTransferServiceImpl implements BTransferService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 7人民币兑换1美元
     */
    @Override
    public void transfer() {
        //1.人民币；2美元
        //系统账户
        Account totalAccount = jdbcTemplate.queryForObject("SELECT * FROM t_account WHERE userid = 0 AND currency = ?", (ResultSet rs, int arg1) -> toAccount(rs), 0, 2);
        //用户账户
        Account account = jdbcTemplate.queryForObject("SELECT * FROM t_account WHERE userid = ? AND currency = ?", (ResultSet rs, int arg1) -> toAccount(rs), 2, 1);
        Account  dollarAccount = jdbcTemplate.queryForObject("SELECT * FROM t_account WHERE userid = ? AND currency = ?", (ResultSet rs, int arg1) -> toAccount(rs), 2, 2);
        //冻结1美元
        jdbcTemplate.update("UPDATE t_account SET balance = balance - ? WHERE account_id = ?", 1, totalAccount.getAccountId());
        //冻结状态:1.冻结;2.解冻
        jdbcTemplate.update("INSERT INTO t_freeze(freeze_id,freeze_amount,currency,freeze_status,account_id) VALUES(?,?,?,?,?) ", 1, 1, 2, 1, 0);
        //用户资金变化
        jdbcTemplate.update("UPDATE t_account SET balance = balance - ? WHERE account_id = ?",7, account.getAccountId());
        jdbcTemplate.update("UPDATE t_account SET balance = balance + ? WHERE account_id = ?",1, dollarAccount.getAccountId());
        //系统账户解冻
        jdbcTemplate.update("UPDATE t_freeze  SET freeze_status =1  WHERE freeze_id = ?", 1);
    }

    @SneakyThrows
    public Account toAccount(ResultSet rs) {
        Account acc = new Account();
        acc.setAccountId(rs.getLong("account_id"));
        acc.setBalance(rs.getLong("balance"));
        acc.setUserid(rs.getLong("userid"));
        acc.setCurrency(rs.getInt("currency"));
        return acc;
    }
}
