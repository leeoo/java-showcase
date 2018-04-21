package com.lex.showcase.gof23.structural.proxy.static_proxy;

/**
 * 代理对象，静态代理
 */
public class UserServiceProxy implements UserService {

    // 接收保存目标对象
    private UserService target;

    public UserServiceProxy(UserService target) {
        this.target = target;
    }

    @Override
    public void save() {
        beforeInvoke();
        target.save(); // 执行目标对象的方法
        afterInvoke();
    }

    private void beforeInvoke() {
        System.out.println("Start transaction!");
    }

    private void afterInvoke() {
        System.out.println("Commit transaction!");
    }
}
