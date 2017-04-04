package com.lex.showcase.gof23.creational.singleton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Lex on 2016/10/29.
 */
public class Client {
    private static Logger log = LogManager.getLogger(Client.class);
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        log.info("Should be " + (instance1 == instance2));
    }
}
