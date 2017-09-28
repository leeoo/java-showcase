package com.lex.showcase.serialization.jackson;

import java.io.Serializable;

/**
 * @author Lex Li
 */
public class MyValue implements Serializable {

    private String name;
    private int age;

    public MyValue() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
