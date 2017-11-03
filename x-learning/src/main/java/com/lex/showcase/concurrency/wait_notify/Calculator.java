package com.lex.showcase.concurrency.wait_notify;

/**
 * @author Lex Li
 */
public class Calculator {

    public double add(double num, double anotherNum) {
        return num + anotherNum;
    }

    public double subtract(double num, double anotherNum) {
        return num - anotherNum;
    }

    public double multiple(double num, double anotherNum) {
        return num * anotherNum;
    }

    public double divide(double num, double anotherNum) {
        if (anotherNum == 0.0) {
            throw new ArithmeticException("Could not divide by 0!");
        }
        return num / anotherNum;
    }
}
