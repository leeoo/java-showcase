package com.lex.showcase.serialization.fastson;

/**
 * @author Lex Li
 */
public class SayHelloImpl implements SayHello {
    public String sayHello(String name) {
        System.out.println(name+" : hello world");
        return name+" : hello world";
    }
}