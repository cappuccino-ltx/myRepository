package com.ltx.bank.mapper;

import com.ltx.bank.pojo.Account;

public interface AccountMapper {

    Account selectAccount(String actno);
    int updateAccount(Account account);
}
