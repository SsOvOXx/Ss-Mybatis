package com.ss.bank.service;

import com.ss.bank.exceptiona.MoneyNotEnoughException;
import com.ss.bank.exceptiona.TransferException;

/**
 * @program: Ss-Mybatis
 * @ClassName AccountService
 * @description:
 * @author: SsOvOXx
 * @create: 2022-09-23 15:43
 * @Version 1.0
 **/
public interface AccountService {
    /**
     * 账户转账业务
     * @param fromActno
     * @param toActno
     * @param money
     */
    void transfer(String fromActno,String toActno,double money) throws MoneyNotEnoughException, TransferException;
}
