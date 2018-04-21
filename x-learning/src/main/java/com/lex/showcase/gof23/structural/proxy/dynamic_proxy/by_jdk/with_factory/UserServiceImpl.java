package com.lex.showcase.gof23.structural.proxy.dynamic_proxy.by_jdk.with_factory;

public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("User is saved!");
    }
}
