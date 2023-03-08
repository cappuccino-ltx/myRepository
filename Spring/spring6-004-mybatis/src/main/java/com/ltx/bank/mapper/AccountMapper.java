package com.ltx.bank.mapper;

import com.ltx.bank.pojo.Account;

import java.util.List;

public interface AccountMapper {

    /**
     * 增加信息
     * @param account
     * @return
     */
    int insert(Account account);

    /**
     * 删除信息
     * @param actno
     * @return
     */
    int deleteByActno(String actno);

    /**
     * 修改信息
     * @param account
     * @return
     */
    int update(Account account);

    /**
     * 查询一条信息
     * @param actno
     * @return
     */
    Account selectByActno(String actno);

    /**
     * 查询所有信息
     * @return
     */
    List<Account> selectAll();
}
