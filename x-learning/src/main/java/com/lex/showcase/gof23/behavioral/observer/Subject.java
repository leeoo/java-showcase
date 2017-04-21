package com.lex.showcase.gof23.behavioral.observer;

import java.util.List;

public interface Subject {	
	void setState(int state);
	
	void attach(Observer o);
	void detach(Observer o);
	
	void notifyObservers(Subject subject);

	int getState();
}
