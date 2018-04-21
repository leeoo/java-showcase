package com.lex.showcase.gof23.structural.proxy.dynamic_proxy.by_jdk.with_factory;

/**
 * 总结：代理对象不需要实现接口，但是目标对象一定要实现接口，否则不能用动态代理。
 */
public class Client {
    public static void main(String[] args) {
        // 目标对象
        UserService target = new UserServiceImpl();
        System.out.println(target.getClass()); // 查看原始的类型
        // 给目标对象，创建代理对象
        UserService proxy = (UserService) new ProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass()); // 查看代理的类型

        // 执行方法 （代理对象）
        proxy.save();
    }
}
