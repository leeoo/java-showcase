package com.lex.showcase.gof23.structural.proxy.dynamic_proxy.by_cglib;

/**
 * 目标对象，没有实现任何接口
 */
public class UserService {
    public void save() {
        System.out.println("User is saved!");
    }
}
