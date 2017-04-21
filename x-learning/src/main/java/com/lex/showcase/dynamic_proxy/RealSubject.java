package com.lex.showcase.dynamic_proxy;

public class RealSubject implements Subject {

	@Override
	public void operate() {
		System.out.println("Operate something.");
	}

}
