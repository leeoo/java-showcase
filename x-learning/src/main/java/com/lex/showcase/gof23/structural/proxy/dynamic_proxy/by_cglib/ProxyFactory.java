package com.lex.showcase.gof23.structural.proxy.dynamic_proxy.by_cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {
    // 维护目标对象
    private  Object target;
    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 给目标对象创建一个代理对象
    public Object getProxyInstance() {
        // 1.工具类
        Enhancer enhancer = new Enhancer();
        // 2.设置父类
        enhancer.setSuperclass(target.getClass());
        // 3.设置回调函数
        enhancer.setCallback(this);
        // 4.创建子类（代理对象）
        return enhancer.create();
    }
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        beforeInvoke();

        // 执行目标对象的方法
        Object result = method.invoke(target, args);

        afterInvoke();
        return result;
    }

    private void beforeInvoke() {
        System.out.println("Starting transaction...");
    }

    private void afterInvoke() {
        System.out.println("Commit transaction...");
    }
}
