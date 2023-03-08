package com.ltx.bank.service;

import com.ltx.bank.pojo.Account;

import java.util.List;

public interface AccountService {

    /**
     * 注册
     * @param act
     * @return
     */
    int save(Account act);

    /**
     * 注销
     * @param actno
     * @return
     */
    int deleteByActno(String actno);

    /**
     * 修改账户信息
     * @param act
     * @return
     */
    int modify(Account act);

    /**
     * 查询单独用户信息
     * @param actno
     * @return
     */
    Account getByActno(String actno);

    /**
     * 查询所有用户信息
     * @return
     */
    List<Account> getAll();

    /**
     * 转账
     * @param fromActno
     * @param toActno
     */
    void transfer(String fromActno, String toActno, Long money);
}
