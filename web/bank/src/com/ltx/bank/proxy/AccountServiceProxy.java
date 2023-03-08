package com.ltx.bank.proxy;

import com.ltx.bank.bean.Account;
import com.ltx.bank.exceptions.AppException;
import com.ltx.bank.exceptions.MoneyNotEnoughException;
import com.ltx.bank.service.AccountService;
import com.ltx.bank.util.DBUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 使用动态代理的机制，创建一个AccountService的一个代理类，
 *      将事务的开启、提交、回滚的逻辑代码交给代理来做，
 *      这样可以使service类中的代码支取处理业务逻辑，
 */
public class AccountServiceProxy  {
    public static AccountService createProxy(AccountService a){

        /**
         * Proxy.newProxyInstance(ClassLoader loader,
         *                      Class<?>[] interfaces,
         *                      InvocationHandler h),
         *      这个方法的第一个参数：指定一个类加载器，只要将本类的getClassLoader()传进去就行
         *      第二个参数：将要代理的类所实现的接口都放进一个数组中传进去就行
         *      第三个参数：用来指定代理的职责（需要做那些事，需要代理那些事）new InvocationHandler(){}
         *              接口的匿名内部类的对象
         */
        //调用Proxy的newProxyInstance()方法
        AccountService proxy = (AccountService)Proxy.newProxyInstance(
                AccountService.class.getClassLoader(),
                new Class[]{AccountService.class},
                new InvocationHandler() {
                    /**
                     *
                     * 这个方法就是动态代理的核心方法，
                     * @param proxy 可以拿到当前代理对象
                     * @param method 这个参数就是需要调用的方法，
                     * @param args 调用方法的参数数组
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args)
                            throws Throwable {
                        Object o = null;
                        //如果执行的是转账的方法，那就将开启事务的代码交给代理去完成
                        if(method.getName().equals("transfer")){
                            //开启事务
                            Connection conn = null;
                            try {
                                conn = DBUtil.getConnection();
                                conn.setAutoCommit(false);
                                //调用转账方法
                                o = method.invoke(a, args);
                                //如果没报异常，就提交
                                conn.commit();
                            } catch (SQLException e) {
                                if (conn != null) {
                                    try {
                                        conn.rollback();
                                    } catch (SQLException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                }
                                throw new RuntimeException(e);
                            } catch(Exception e){
                                throw new AppException("出现为预知的错误！");
                            }



                        }
                        else{//如果不是，是其他的普通方法，那就不需要代理处理，直接让放行
                            o = method.invoke(a, args);
                        }
                        return o;
                    }
                }
        );
        return proxy;
    }
}
