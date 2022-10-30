package com.ss.bank.exceptiona;

/**
 * @program: Ss-Mybatis
 * @ClassName MoneyNotEnoughException
 * 余额不足异常
 * @description:
 * @author: SsOvOXx
 * @create: 2022-09-23 19:25
 * @Version 1.0
 **/
public class MoneyNotEnoughException extends Exception{
    public MoneyNotEnoughException(){}
    public MoneyNotEnoughException(String msg){
        super(msg);
    }
}