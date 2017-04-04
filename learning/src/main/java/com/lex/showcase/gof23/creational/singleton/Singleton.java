package com.lex.showcase.gof23.creational.singleton;

/**
 * Created by Lex on 2016/10/29.
 */
public class Singleton {

    private Singleton() {

    }

    public static Singleton getInstance() {
        return Holder.instance;
    }

    private static final class Holder {
        private static final Singleton instance = new Singleton();
    }
}
