package com.java.spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 1.创建 IOC 容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        // 2.获取 bean 示例
        AopHello aopHello = (AopHello) ctx.getBean("aopHelloImpl");

        System.out.println("--------------------------------");

        // 3.使用
        int result1 = aopHello.add(1, 2);
        System.out.println("result: "+result1);

        System.out.println("--------------------------------");

        int div = aopHello.div(6, 2);
        System.out.println(div);
    }
}
