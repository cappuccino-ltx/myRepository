package com.ltx.bank.service;

import com.ltx.bank.exceptions.AppException;
import com.ltx.bank.exceptions.MoneyNotEnoughException;

import java.sql.SQLException;

public interface AccountService {
    void transfer(String fromAct,String toAct,double money)
            throws MoneyNotEnoughException, AppException, SQLException;
}
