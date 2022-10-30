package com.ss.bank.dao;

import com.ss.bank.pojo.Account;

/**
 * @program: Ss-Mybatis
 * @ClassName AccountDao
 * @description:
 * @author: SsOvOXx
 * @create: 2022-09-23 18:35
 * @Version 1.0
 **/
public interface AccountDao {
     Account selectByActno(String actno);

     int updateByActno(Account account);
}
