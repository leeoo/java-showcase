package com.lex.showcase.java8_features.lambda_expression;

public abstract class ProcessingObject<T> {
    private ProcessingObject<T> successor;

    public void setProcessingObject(ProcessingObject<T> successor) {
        this.successor = successor;
    }

    public T handle(T input) {
        T r = handleWork(input);

        if (successor != null) {
            return successor.handle(r);
        }
        return r;
    }

    protected abstract T handleWork(T input);
}
