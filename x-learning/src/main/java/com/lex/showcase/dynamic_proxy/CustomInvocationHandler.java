package com.lex.showcase.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {
	private Object subject;

	public CustomInvocationHandler(Object subject) {
		this.subject = subject;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		beforeInvoke();
		result = method.invoke(subject, args);
		afterInvoke();
		return result;
	}

	private void beforeInvoke() {
		System.out.println("Do something before invocation...");
	}

	private void afterInvoke() {
		System.out.println("Do something after invocation...");
	}

}
