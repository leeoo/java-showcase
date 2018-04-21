package com.lex.showcase.gof23.structural.proxy.dynamic_proxy.by_jdk.normal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserServiceInvocationHandler implements InvocationHandler {
    private UserService target;

    public UserServiceInvocationHandler(UserService target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforeInvoke();
        Object result = method.invoke(target, args);
        afterInvoke();
        return result;
    }

    private void beforeInvoke() {
        System.out.println("Starting transaction...");
    }

    private void afterInvoke() {
        System.out.println("Commit transaction.");
    }

}
