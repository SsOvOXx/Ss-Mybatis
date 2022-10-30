package com.ss.bank.exceptiona;

/**
 * @program: Ss-Mybatis
 * @ClassName TransferException
 * @description:
 * @author: SsOvOXx
 * @create: 2022-09-23 19:38
 * @Version 1.0
 **/
public class TransferException extends Exception{
    public TransferException (){}
    public TransferException(String msg){
        super(msg);
    }
}