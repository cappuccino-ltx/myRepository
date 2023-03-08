package com.ltx.bank.web;

import com.ltx.bank.exception.AccountAbsentException;
import com.ltx.bank.exception.MoneyNotEnoughException;
import com.ltx.bank.service.AccountService;
import com.ltx.bank.service.impl.AccountServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/transfer")
public class bankServlet extends HttpServlet {
    AccountService accountService = new AccountServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/hmtl;charset=utf-8");
        PrintWriter out = response.getWriter();
        String fromact = request.getParameter("fromact");
        String toact = request.getParameter("toact");
        Double money = Double.parseDouble(request.getParameter("money"));
        //转账
        try {
            accountService.transfer(fromact,toact,money);
            out.print("转账成功！");
        } catch (AccountAbsentException e) {
            out.print(e.getMessage());
            //throw new RuntimeException(e);
        } catch (MoneyNotEnoughException e) {
            out.print(e.getMessage());
            //throw new RuntimeException(e);
        }catch (Exception e){
            out.print("程序遇到了不可预知的错误！");
            throw new RuntimeException(e);
        }
    }
}
