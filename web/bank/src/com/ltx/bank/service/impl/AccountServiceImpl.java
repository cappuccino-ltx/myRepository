package com.ltx.bank.service.impl;

import com.ltx.bank.bean.Account;
import com.ltx.bank.dao.AccountDao;
import com.ltx.bank.dao.impl.AccountDaoImpl;
import com.ltx.bank.exceptions.AppException;
import com.ltx.bank.exceptions.MoneyNotEnoughException;
import com.ltx.bank.service.AccountService;
import com.ltx.bank.util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;


public class AccountServiceImpl implements AccountService {

    AccountDao actdao = new AccountDaoImpl();
    /**
     * 用户转账业务逻辑的实现
     * @param fromAct 转出账户
     * @param toAct 转入账户
     * @param money 转账余额
     */
    @Override
    public void transfer(String fromAct, String toAct, double money)
            throws MoneyNotEnoughException, SQLException {

        Account froma = actdao.select(fromAct);
        if (froma.getBalance() < money){
            //数额不够，抛出异常
            throw new MoneyNotEnoughException("余额不足，转账失败！");
        }else{
            Account toa = actdao.select(toAct);
            froma.setBalance(froma.getBalance() - money);
            toa.setBalance(toa.getBalance() + money);
            //持久化数据
            actdao.update(froma);
            //模拟异常
            /*String a = null;
            a.equals(" ");*/
            actdao.update(toa);
        }
        /*
        //先查询转出账户找中的数额是否够用
        Account froma = actdao.select(fromAct);
        if (froma.getBalance() < money){
            //数额不够，抛出异常
            throw new MoneyNotEnoughException("余额不足，转账失败！");
        }else{
            //余额充足，开启事务，实现转账

            try (Connection conn = DBUtil.getConnection()){
                conn.setAutoCommit(false);
                Account toa = actdao.select(toAct);
                froma.setBalance(froma.getBalance() - money);
                toa.setBalance(toa.getBalance() + money);
                //持久化数据
                actdao.update(froma);
                //模拟异常
                //String a = null;
                a.equals(" ");
                //
                actdao.update(toa);
                conn.commit();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }catch(Exception e){
                throw new AppException("应用出现不可预知的错误！");
            }
        }
        */

    }
}
