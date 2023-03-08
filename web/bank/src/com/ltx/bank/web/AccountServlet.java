package com.ltx.bank.web;

import com.ltx.bank.exceptions.AppException;
import com.ltx.bank.exceptions.MoneyNotEnoughException;
import com.ltx.bank.proxy.AccountServiceProxy;
import com.ltx.bank.service.AccountService;
import com.ltx.bank.service.impl.AccountServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fromAct = request.getParameter("fromAct");
        String toAct = request.getParameter("toAct");
        double money = Double.parseDouble(request.getParameter("money"));
        //实现转账功能
        //不使用动态代理
        //AccountService accountService = new AccountServiceImpl();
        //使用动态代理
        AccountServiceImpl a = new AccountServiceImpl();
        AccountService accountService = AccountServiceProxy.createProxy(a);
        try {
            accountService.transfer(fromAct, toAct, money);
            response.sendRedirect(request.getContextPath() + "/success.jsp");
        } catch (MoneyNotEnoughException e) {
            //throw new RuntimeException(e);
            response.sendRedirect(request.getContextPath() + "/moneyNotEnough.jsp");
        } catch (AppException e) {
            //throw new RuntimeException(e);
            response.sendRedirect(request.getContextPath() + "/fail.jsp");
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            response.sendRedirect(request.getContextPath() + "/fail.jsp");
        }

    }
}
