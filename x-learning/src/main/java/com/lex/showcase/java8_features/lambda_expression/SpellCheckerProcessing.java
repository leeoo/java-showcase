package com.lex.showcase.java8_features.lambda_expression;

public class SpellCheckerProcessing extends ProcessingObject<String> {

    @Override
    protected String handleWork(String input) {
        return input.replaceAll("labda", "lambda");
    }
}
