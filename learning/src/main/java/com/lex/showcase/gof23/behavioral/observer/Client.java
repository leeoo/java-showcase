package com.lex.showcase.gof23.behavioral.observer;

public class Client {

	public static void main(String[] args) {
		Observer obA = new ConcreteObserver("A");
		Observer obB = new ConcreteObserver("B");
		Subject subject = new ConcreteSubject();
		subject.attach(obA);
		subject.attach(obB);

		subject.setState(ConcreteSubject.DEFAULT);

		subject.setState(ConcreteSubject.GOOD);

		subject.setState(ConcreteSubject.BAD);
	}

}
