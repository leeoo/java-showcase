package com.lex.showcase.gof23.structural.proxy.dynamic_proxy.by_jdk.with_factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理工厂类，创建动态代理对象
 * 动态代理不需要实现接口，但是需要指定接口类型
 */
public class ProxyFactory {
    // 维护一个目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 给目标对象生成代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        beforeInvoke();
                        // 执行目标对象方法
                        Object result = method.invoke(target, args);
                        afterInvoke();
                        return result;
                    }
                });
    }

    private void beforeInvoke() {
        System.out.println("Starting transaction...");
    }

    private void afterInvoke() {
        System.out.println("Commit transaction.");
    }

}
