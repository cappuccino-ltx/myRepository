package com.ltx.spring.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component
@Aspect//切面类是需要用@Aspect注解标注
public class LogAspect {//切面类


    /**
     * 切面 = 切点 + 通知、
     * 通知就是增强，就是具体要编写的增强代码
     *
     *  \@Before 是一个前置通知
     */

    @Pointcut("execution(* com.ltx.spring.service.UserService.login(..))")
    public void pointcut(){}

    //前置通知
    @Before("pointcut()")
    public void beforeAdvice(){
        System.out.println("前置通知");
    }

    //后置通知
    @AfterReturning("pointcut()")
    public void afterAdvice(){
        System.out.println("后置通知！");
    }

    //环绕通知
    @Around("pointcut()")
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        //前环绕
        System.out.println("前环绕通知！");
        //调用
        proceedingJoinPoint.proceed();
        //后环绕
        System.out.println("后环绕通知！");
    }

    //异常通知
    @AfterThrowing("pointcut()")
    public void throwAdvice(){
        System.out.println("异常通知！");
    }

}
