package com.lex.showcase.gof23.structural.proxy.dynamic_proxy.by_jdk.normal;

import java.lang.reflect.Proxy;

/**
 * 动态代理有以下特点：
 * 1. 代理对象，不需要实现接口。
 * 2. 代理对象的生成，是利用JDK的API，动态的在内存中构建代理对象（需要我们指定创建代理对象/目标对象实现的接口类型）
 * 3. 动态代理也叫作：JDK代理，接口代理
 *
 * 代理模式简述：先建立目标对象和代理对象的联系，然后代用代理对象中的同名方法。
 */
public class Client {
    public static void main(String[] args) {
        UserService target = new UserServiceImpl();
        UserServiceInvocationHandler handler = new UserServiceInvocationHandler(target);

        UserService proxy = (UserService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);
        proxy.save();
    }
}
