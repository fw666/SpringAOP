package com.java.spring.aop.impl;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 把这个类申明为一个切面：1.将该类放入 IOC 容器中。2.将该类声明为一个切面(Aspect)
 */
@Component
@Aspect
public class LoggingAspect {
    /**
     * 声明该方法是在目标方法执行之前执行
     */
    @Before("execution(public int com.java.spring.aop.impl.AopHello.*(int,int))")
    public  void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method "+methodName+" begins " + args);
    }

    // 后置通知就是在目标方法执行后（无论是否发生异常）执行的通知。
    @After("execution(* com.java.spring.aop.impl.*.*(int ,int ))")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+methodName+" ends");
    }
    @AfterReturning(value = "execution(public int com.java.spring.aop.impl.*.*(..))",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        String name = joinPoint.getSignature().getName();
        System.out.println("The method "+name+" ends with "+ result);
    }
}
