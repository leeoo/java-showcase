package com.lex.showcase.java8_features.lambda_expression;

public class HeaderTextProcessing extends ProcessingObject<String> {

    @Override
    protected String handleWork(String input) {
        return "Hello, " + input;
    }
}
