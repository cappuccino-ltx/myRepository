package com.ltx.spring.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransferAspect {

    @Around("execution(* com.ltx.spring.service.UserTransfer.*(..))")
    public void transactionAspect(ProceedingJoinPoint proceedingJoinPoint){
        try {
            System.out.println("事务开启");
            proceedingJoinPoint.proceed();
            System.out.println("事务提交");
        } catch (Throwable e) {
            //throw new RuntimeException(e);
            System.out.println("事务回滚");
        }

    }
}
