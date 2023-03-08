package com.ltx.bank.service.impl;

import com.ltx.bank.mapper.AccountMapper;
import com.ltx.bank.exception.AccountAbsentException;
import com.ltx.bank.exception.MoneyNotEnoughException;
import com.ltx.bank.pojo.Account;
import com.ltx.bank.service.AccountService;
import com.ltx.bank.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountServiceImpl implements AccountService {
    //AccountDao accountDao = new AccountDaoImpl();
    //不需要写dao层的实现类以后，使用mybatis提供的javassist机制，来动态创建dao层接口的实现类
    AccountMapper accountDao = SqlSessionUtil.getSqlSession().getMapper(AccountMapper.class);
    @Override
    public void transfer(String fromact, String toact, Double money) throws AccountAbsentException, MoneyNotEnoughException {
        //编写事务代码
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        //查询用户，确定账户都存在，且转出账户有足够的余额
        Account fromAct = accountDao.selectAccount(fromact);
        if (fromAct == null) {
            throw new AccountAbsentException("转出账户不存在！");
        }
        Account toAct = accountDao.selectAccount(toact);
        if (toAct == null) {
            throw new AccountAbsentException("转入账户不存在！");
        }
        if (fromAct.getBalance() < money){
            throw new MoneyNotEnoughException("转出账户余额不足！");
        }
        //修改内存中的余额，
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);
        //改变数据库中的信息
        int count = accountDao.updateAccount(fromAct);

        /*String s = null;
        s.toString();*/

        count += accountDao.updateAccount(toAct);
        //提交
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }
}
