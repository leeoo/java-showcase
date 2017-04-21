package com.lex.showcase.dynamic_proxy;

import java.lang.reflect.Proxy;

public class Client {

	public static void main(String[] args) {
		Subject subject = new RealSubject();
		CustomInvocationHandler invocationHandler = new CustomInvocationHandler(subject);

		Subject proxy = (Subject) Proxy.newProxyInstance(subject.getClass().getClassLoader(),
				subject.getClass().getInterfaces(),
				invocationHandler);

		proxy.operate();
	}

}
