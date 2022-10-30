package com.ss.bank.service.impl;

import com.ss.bank.dao.AccountDao;
import com.ss.bank.dao.impl.AccountDaoImpl;
import com.ss.bank.exceptiona.MoneyNotEnoughException;
import com.ss.bank.exceptiona.TransferException;
import com.ss.bank.pojo.Account;
import com.ss.bank.service.AccountService;
import com.ss.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @program: Ss-Mybatis
 * @ClassName AccountServiceImpl
 * @description:
 * @author: SsOvOXx
 * @create: 2022-09-23 15:56
 * @Version 1.0
 **/
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao = new AccountDaoImpl();
    //private AccountDao accountDao = (AccountDao) GenerateDaoProxy.generate(SqlSessionUtil.openSession(), AccountDao.class);
    @Override
    public void transfer(String fromActno, String toActno, double money) throws MoneyNotEnoughException, TransferException {
        //事务控制代码
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // 1.判断转出账户的余额是否充足
        Account fromAct = accountDao.selectByActno(fromActno);
        if (fromAct.getBalance() < money) {
            // 2.如果转出账户不足，提示用户
            throw new MoneyNotEnoughException("抱歉，余额不足！");
        }
        // 3.如果转出账户余额充足，更新转出账户余额
        //   先更新java对象中的account余额，再更新mysql
        Account toAct = accountDao.selectByActno(toActno);
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);
        int count = accountDao.updateByActno(fromAct);
        // 模拟异常
        // String str = null;
        // str.toString();
        // 4.更新转入账户余额
        count += accountDao.updateByActno(toAct);
        if (count != 2) {
            throw new TransferException("转账异常，未知原因！");
        }

        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }
}