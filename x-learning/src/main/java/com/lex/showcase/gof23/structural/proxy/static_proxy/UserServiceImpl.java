package com.lex.showcase.gof23.structural.proxy.static_proxy;

public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("User is saved!");
    }
}
