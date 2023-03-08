package com.ltx.bank.dao.impl;

import com.ltx.bank.bean.Account;
import com.ltx.bank.dao.AccountDao;
import com.ltx.bank.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements AccountDao {


    /**
     * 插入用户信息
     * @param account 要插入的用户对象
     * @return 返回1代表成功
     */
    @Override
    public int insert(Account account) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;

        conn = DBUtil.getConnection();
        String sql = "insert into t_acr(id,actno,balance) values(?,?,?)";
        ps = conn.prepareStatement(sql);
        ps.setLong(1,account.getId());
        ps.setString(2,account.getActno());
        ps.setDouble(3,account.getBalance());
        count = ps.executeUpdate();

        DBUtil.close(null,ps,null);

        return count;
    }

    /**
     * 更新账户信息
     * @param account 要更新的账户信息对象
     * @return 更新成功返回1
     */
    @Override
    public int update(Account account) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;

        conn = DBUtil.getConnection();
        String sql = "update t_act set balance=? where actno=?";
        ps = conn.prepareStatement(sql);
        ps.setDouble(1,account.getBalance());
        ps.setString(2,account.getActno());
        count = ps.executeUpdate();

        DBUtil.close(null,ps,null);

        return count;
    }

    /**
     * 删除指定账户
     * @param account 账户对象
     * @return 返回1代表删除成功
     */
    @Override
    public int remove(Account account) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;

        conn = DBUtil.getConnection();
        String sql = "delete from t_act where id=?";
        ps = conn.prepareStatement(sql);
        ps.setLong(1,account.getId());
        count = ps.executeUpdate();

        DBUtil.close(null,ps,null);

        return count;
    }

    /**
     * 查询指定账户的信息
     * @param act 账号
     * @return 该账户的信息
     */
    @Override
    public Account select(String act) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Account account = new Account();

        conn = DBUtil.getConnection();
        String sql = "select id,actno,balance from t_act where actno = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1,act);
        rs = ps.executeQuery();
        if(rs.next()){
            account.setId(rs.getLong("id"));
            account.setActno(rs.getString("actno"));
            account.setBalance(rs.getDouble("balance"));
        }

        DBUtil.close(null,ps,rs);

        return account;
    }

    /**
     * 查询所有用户信息
     * @return 存放用户信息的list
     */
    @Override
    public List<Account> select() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Account> list = new ArrayList<>();

        conn = DBUtil.getConnection();
        String sql = "select id,actno,balance from t_act";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next()){
            Account account  = new Account();
            account.setId(rs.getLong("id"));
            account.setActno(rs.getString("actno"));
            account.setBalance(rs.getDouble("balance"));
            list.add(account);
        }

        DBUtil.close(null,ps,rs);

        return list;
    }
}
