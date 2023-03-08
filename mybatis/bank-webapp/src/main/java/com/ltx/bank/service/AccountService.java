package com.ltx.bank.service;

import com.ltx.bank.exception.AccountAbsentException;
import com.ltx.bank.exception.MoneyNotEnoughException;

public interface AccountService {

    void transfer(String fromact, String toact, Double money) throws AccountAbsentException, MoneyNotEnoughException;
}
