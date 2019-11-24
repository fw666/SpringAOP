package com.java.spring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyLogging {
    // 要代理的对象
    private AopHello target;

    public ProxyLogging(AopHello target) {
        this.target = target;
    }

    /**
     * 为 AopHello 生成代理对象
     *
     * @return AopHello 的代理对象
     */
    public AopHello getAopHelloProxy(){
        AopHello proxy = null;
        // 代理对象由哪一个类加载器负责加载
        ClassLoader loader = target.getClass().getClassLoader();
        // 代理对象的类型
        Class[] interfaces = {AopHello.class};
        // 当代理对象执行其中的方法时
        InvocationHandler h = new InvocationHandler(){
            /**
             * param:
             *      1.proxy: 正在返回的那个代理对象。一般情况下，在 invoke 方法中都不使用这个方法。
             *      2.method: 正在被调用的方法。
             *      3.args: 调用方式时传入的参数。
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                // 日志
                System.out.println("The method["+ methodName +"] begins with "+ Arrays.asList(args));
                // 执行方法
                Object result = method.invoke(target,args);
                System.out.println("The method[" + methodName +"] ends with" + result);
                return result;
            }
        };
        proxy = (AopHello) Proxy.newProxyInstance(loader, interfaces, h);

        return proxy;
    }
}
