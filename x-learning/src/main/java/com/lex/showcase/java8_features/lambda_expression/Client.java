package com.lex.showcase.java8_features.lambda_expression;

/**
 * 《Java 8实战》8.2.4
 * 责任链模式与模板方法模式相结合
 */
public class Client {

    public static void main(String[] args) {
        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckerProcessing();
        p1.setProcessingObject(p2);

        String result = p1.handle("labda is interesting");

        System.out.println(result);
    }
}
