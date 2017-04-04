package com.lex.showcase.gof23.behavioral.observer;

public class ConcreteObserver implements Observer {

	private int observerState; 
	private String name;
	
	public ConcreteObserver(String name) {
		this.name = name;
	}
	
	@Override
	public void update(Subject subject) {
		observerState = subject.getState();
		System.out.println(String.format("Subject's state changed, so update Observer[%s].", name));
	}

}
