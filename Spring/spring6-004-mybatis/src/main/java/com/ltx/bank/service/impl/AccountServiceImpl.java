package com.ltx.bank.service.impl;

import com.ltx.bank.mapper.AccountMapper;
import com.ltx.bank.pojo.Account;
import com.ltx.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public int save(Account act) {
        return accountMapper.insert(act);
    }

    @Override
    public int deleteByActno(String actno) {
        return accountMapper.deleteByActno(actno);
    }

    @Override
    public int modify(Account act) {
        return accountMapper.update(act);
    }

    @Override
    public Account getByActno(String actno) {
        return accountMapper.selectByActno(actno);
    }

    @Override
    public List<Account> getAll() {
        return accountMapper.selectAll();
    }

    @Override
    public void transfer(String fromActno, String toActno, Long money) {

        Account fromAct = accountMapper.selectByActno(fromActno);
        Account toAct = accountMapper.selectByActno(toActno);
        if (fromAct.getBalance() < money) {
            throw new RuntimeException("余额不足！");
        }

        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);

        int count = accountMapper.update(fromAct);
        count += accountMapper.update(toAct);

        if (count != 2){
            throw new RuntimeException("转账失败！");
        }
    }

}
