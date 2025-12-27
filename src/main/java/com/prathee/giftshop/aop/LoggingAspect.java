package com.prathee.giftshop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.prathee.giftshop.controller.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("API START: " + joinPoint.getSignature());
    }

    @AfterReturning("execution(* com.prathee.giftshop.controller.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("API END: " + joinPoint.getSignature());
    }
}
