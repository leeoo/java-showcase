package com.lex.showcase.gof23.structural.proxy.static_proxy;

public class Client {

    public static void main(String[] args) {
        // 目标对象
        UserService target = new UserServiceImpl();

        // 代理对象，把目标对象传给代理对象，建立代理关系
        UserServiceProxy userServiceProxy = new UserServiceProxy(target);

        userServiceProxy.save(); // 执行的是代理的方法
    }
}