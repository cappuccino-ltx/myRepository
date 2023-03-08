package com.ltx.bank.mapper.impl;

import com.ltx.bank.mapper.AccountMapper;
import com.ltx.bank.pojo.Account;
import com.ltx.bank.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountMapperImpl implements AccountMapper {
    SqlSession session = SqlSessionUtil.getSqlSession();
    @Override
    public Account selectAccount(String actno) {
        Account act = session.selectOne("selectAccount", actno);
        return act;
    }

    @Override
    public int updateAccount(Account account) {
        int count = session.update("updateAccount", account);
        return count;
    }
}
