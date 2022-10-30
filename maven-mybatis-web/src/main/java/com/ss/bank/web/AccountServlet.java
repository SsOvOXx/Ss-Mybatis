package com.ss.bank.web;

import com.ss.bank.exceptiona.MoneyNotEnoughException;
import com.ss.bank.exceptiona.TransferException;
import com.ss.bank.service.AccountService;
import com.ss.bank.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: Ss-Mybatis
 * @ClassName AccountServlet
 * @description:
 * @author: SsOvOXx
 * @create: 2022-09-23 15:03
 * @Version 1.0
 **/

// @WebServlet("/transfer")
public class AccountServlet extends HttpServlet {
    //为了让这个对象在其他对象中也可以被使用，声明为实例变量
    private AccountService accountService = new AccountServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取表单数据
        String fromActno = request.getParameter("fromActno");
        String toActno = request.getParameter("toActno");
        //将String类型的money转化为double类型
        double money = Double.parseDouble(request.getParameter("money"));
        //调用service的转账方法完成转账（调业务层）
        try {
            accountService.transfer(fromActno, toActno, money);
            response.sendRedirect(request.getContextPath() + "/success.html");
        } catch (MoneyNotEnoughException e) {
            response.sendRedirect(request.getContextPath() + "/error1.html");
        } catch (TransferException e) {
            response.sendRedirect(request.getContextPath() + "/error2.html");
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/error2.html");
        }
        //调用view完成展示结果
    }
}