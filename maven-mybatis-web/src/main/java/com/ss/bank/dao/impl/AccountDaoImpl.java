package com.ss.bank.dao.impl;

import com.ss.bank.dao.AccountDao;
import com.ss.bank.pojo.Account;
import com.ss.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @program: Ss-Mybatis
 * @ClassName AccountDaoImpl
 * @description:
 * @author: SsOvOXx
 * @create: 2022-09-23 18:54
 * @Version 1.0
 **/
public class AccountDaoImpl implements AccountDao {
    @Override
    public Account selectByActno(String actno) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Account account = (Account) sqlSession.selectOne("account.selectByActno", actno);
        return account;
    }

    @Override
    public int updateByActno(Account act) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.update("account.updateByActno", act);
        return count;
    }
}