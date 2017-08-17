package com.lex.showcase.java8_features.lambda_expression;

import java.io.File;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ClientWithLambdaExpression {
    public static void main(String[] args) {
        UnaryOperator<String> headerTextProcessing = (String s) -> "Hello, " + s;
        UnaryOperator<String> spellCheckerProcessing = (String s) -> s.replaceAll("labda", "lambda");

        Function<String, String> pipeline = headerTextProcessing.andThen(spellCheckerProcessing);
        String result = pipeline.apply("labda is interesting!");
        System.out.println(result);
    }
}
