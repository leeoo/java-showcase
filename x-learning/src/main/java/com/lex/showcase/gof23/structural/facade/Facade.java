package com.lex.showcase.gof23.structural.facade;

public class Facade {

	private SystemA systemA;
	private SystemB systemB;
	private SystemC systemC;

	public Facade() {
		systemA = new SystemA();
		systemB = new SystemB();
		systemC = new SystemC();
	}

	public void wrapOperation() {
		systemA.operationA();
		systemB.operationB();
		systemC.operationC();
	}
}
