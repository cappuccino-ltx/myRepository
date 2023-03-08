package com.ltx.bank.dao;

import com.ltx.bank.bean.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountDao {
    int insert(Account account) throws SQLException;
    int update(Account account) throws SQLException;
    int remove(Account account) throws SQLException;
    Account select(String act) throws SQLException;
    List<Account> select() throws SQLException;
}
