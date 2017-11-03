package com.smart.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Lex Li
 */
public class PerformanceHandler implements InvocationHandler {
    private Object target; // 目标业务类

    public PerformanceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.begin(target.getClass().getName() + "." + method.getName());
        Object obj = method.invoke(target, args); // 通过反射方法调用业务类的目标方法
        PerformanceMonitor.end();
        return obj;
    }
}
