package com.java.spring;

public class Main {
    public static void main(String[] args) {
        AopHello aopHello = new AopHelloImpl();
        /**
         * aopHello: 代理的 目标对象
         */
        ProxyLogging proxy = new ProxyLogging(aopHello);
        AopHello helloProxy = proxy.getAopHelloProxy();

        int add = helloProxy.add(4, 5);

        System.out.println("result: "+add);
    }
}
