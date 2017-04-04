package com.lex.showcase.gof23.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {
	
	private List<Observer> observers;
	
	private int state;
	
	public static final int DEFAULT = 0;
	public static final int GOOD = 1;
	public static final int BAD = -1;

	
	public ConcreteSubject() {
		this.observers = new ArrayList<>();
	}

	@Override
	public int getState() {
		return state;
	}
	
	
	@Override
	public void setState(int state) {
		if (isChanged(state)) {
			System.out.println(String.format("The state is changed from '%s' to '%s'!", this.state, state));
			this.state = state;
			notifyObservers(this);
		} else {
			System.out.println("The state is not changed.");
		}
	}
	
	public List<Observer> getObservers() {
		return observers;
	}

	public boolean isChanged(int state) {
		return this.state != state;
	}

	@Override
	public void attach(Observer o) {
		getObservers().add(o);
	}

	@Override
	public void detach(Observer o) {
		getObservers().remove(o);
	}

	@Override
	public void notifyObservers(Subject subject) {
		for (Observer o : getObservers()) {
			o.update(subject);
		}
	}
	
	
}
